package edu.sperek.jwtpushnotif.infrastructure.repository;

import edu.sperek.jwtpushnotif.domain.model.User;
import edu.sperek.jwtpushnotif.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class MockUserRepository implements UserRepository {

  private static final List<User> users = new ArrayList<>();

  @Override
  public User save(User user) {
    users.add(user);
    return user;
  }

  @Override
  public List<User> findAll() {
    return users;
  }
}
