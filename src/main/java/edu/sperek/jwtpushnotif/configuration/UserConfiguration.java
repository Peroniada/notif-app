package edu.sperek.jwtpushnotif.configuration;

import edu.sperek.jwtpushnotif.application.UserServiceImpl;
import edu.sperek.jwtpushnotif.domain.repository.UserRepository;
import edu.sperek.jwtpushnotif.domain.service.UserService;
import edu.sperek.jwtpushnotif.infrastructure.MockUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

  @Bean
  UserService userService() {
    return new UserServiceImpl(userRepository());
  }

  private UserRepository userRepository() {
    return new MockUserRepository();
  }

}
