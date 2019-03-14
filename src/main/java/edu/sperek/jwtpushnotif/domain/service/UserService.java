package edu.sperek.jwtpushnotif.domain.service;

import edu.sperek.jwtpushnotif.domain.model.entity.User;

import java.util.Collection;

public interface UserService {

  void createUser(User user);

  Collection<User> getUsers();
}
