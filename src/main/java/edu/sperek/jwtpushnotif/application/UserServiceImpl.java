package edu.sperek.jwtpushnotif.application;

import edu.sperek.jwtpushnotif.domain.model.entity.User;
import edu.sperek.jwtpushnotif.domain.repository.UserRepository;
import edu.sperek.jwtpushnotif.domain.service.UserService;

import java.util.Collection;

public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void createUser(User user) {
    userRepository.save(user);
  }

  @Override
  public Collection<User> getUsers() {
    return userRepository.findAll();
  }
}
