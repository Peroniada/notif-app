package edu.sperek.jwtpushnotif.domain.repository;

import edu.sperek.jwtpushnotif.domain.model.User;
import java.util.Collection;

public interface UserRepository {
  void save(User user);
  Collection<User> findAll();
}
