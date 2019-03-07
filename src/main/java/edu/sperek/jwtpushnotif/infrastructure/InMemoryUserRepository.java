package edu.sperek.jwtpushnotif.infrastructure;

import edu.sperek.jwtpushnotif.domain.model.User;
import edu.sperek.jwtpushnotif.domain.repository.UserRepository;
import java.util.Collection;
import java.util.HashSet;

public class InMemoryUserRepository implements UserRepository {

  private final static Collection<User> users = new HashSet<>();

  @Override
  public void save(User user) {
    users.add(user);
  }

  @Override
  public Collection<User> findAll() {
    return users;
  }
}
