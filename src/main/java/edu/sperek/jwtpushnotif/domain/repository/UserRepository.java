package edu.sperek.jwtpushnotif.domain.repository;

import edu.sperek.jwtpushnotif.domain.model.entity.User;

import java.util.List;

public interface UserRepository {

  User save(User user);

  List<User> findAll();
}
