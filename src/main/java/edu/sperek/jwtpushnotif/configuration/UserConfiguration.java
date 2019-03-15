package edu.sperek.jwtpushnotif.configuration;

import edu.sperek.jwtpushnotif.application.UserServiceImpl;
import edu.sperek.jwtpushnotif.domain.repository.UserRepository;
import edu.sperek.jwtpushnotif.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UserConfiguration {

  private final UserRepository userRepository;

  @Autowired
  public UserConfiguration(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Bean
  UserService userService() {
    return new UserServiceImpl(userRepository, bCryptPasswordEncoder());
  }
  @Bean
  BCryptPasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
