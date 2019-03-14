package edu.sperek.jwtpushnotif.domain.repository;

import java.util.List;

public interface UserRepository<T> {
  <S extends T> S save(S user);

  <S extends T> List<S> findAll();
}
