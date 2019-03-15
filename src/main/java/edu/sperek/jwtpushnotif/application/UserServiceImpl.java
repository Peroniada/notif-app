package edu.sperek.jwtpushnotif.application;

import edu.sperek.jwtpushnotif.domain.model.entity.AppUser;
import edu.sperek.jwtpushnotif.domain.repository.UserRepository;
import edu.sperek.jwtpushnotif.domain.service.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserServiceImpl(
      UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public void login(AppUser appUser) {
    
  }

  @Override
  public void singUp(AppUser appUser) {
    appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
    userRepository.save(appUser);
  }

  @Override
  public void createUser(AppUser appUser) {
    userRepository.save(appUser);
  }

  @Override
  public Collection<AppUser> getUsers() {
    return userRepository.findAll();
  }
}
