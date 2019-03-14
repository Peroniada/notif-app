package edu.sperek.jwtpushnotif.configuration;

import edu.sperek.jwtpushnotif.application.UserServiceImpl;
import edu.sperek.jwtpushnotif.domain.repository.UserRepository;
import edu.sperek.jwtpushnotif.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

  @Autowired private UserRepository userRepository;

  @Bean
  UserService userService() {
    return new UserServiceImpl(userRepository);
  }
}
