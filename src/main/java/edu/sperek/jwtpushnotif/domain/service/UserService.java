package edu.sperek.jwtpushnotif.domain.service;

import edu.sperek.jwtpushnotif.domain.model.entity.AppUser;

import java.util.Collection;

public interface UserService {

  void login(AppUser appUser);
  void singUp(AppUser appUser);
  void createUser(AppUser appUser);

  Collection<AppUser> getUsers();
}
