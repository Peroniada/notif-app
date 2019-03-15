package edu.sperek.jwtpushnotif.domain.repository;

import edu.sperek.jwtpushnotif.domain.model.entity.AppUser;

import java.util.List;

public interface UserRepository {

  AppUser save(AppUser appUser);

  List<AppUser> findAll();

  AppUser findByMail(String mail);
}
