package edu.sperek.jwtpushnotif.security;

import edu.sperek.jwtpushnotif.domain.model.entity.AppUser;
import edu.sperek.jwtpushnotif.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
      AppUser appUser = userRepository.findByMail(mail);

      if (appUser == null){
          throw new UsernameNotFoundException(mail);
      }

      return new User(appUser.getMail(), appUser.getPassword(), Collections.emptyList());
  }
}
