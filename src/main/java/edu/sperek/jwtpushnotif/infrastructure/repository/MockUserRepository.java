package edu.sperek.jwtpushnotif.infrastructure.repository;

import edu.sperek.jwtpushnotif.domain.model.entity.AppUser;
import edu.sperek.jwtpushnotif.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class MockUserRepository implements UserRepository {

  private static final List<AppUser> APP_USERS = new ArrayList<>();

  @Override
  public AppUser save(AppUser appUser) {
    APP_USERS.add(appUser);
    return appUser;
  }

  @Override
  public List<AppUser> findAll() {
    return APP_USERS;
  }

  @Override
  public AppUser findByMail(String mail) {
    return null;
  }
}
