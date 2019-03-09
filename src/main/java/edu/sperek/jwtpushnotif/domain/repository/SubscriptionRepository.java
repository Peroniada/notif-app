package edu.sperek.jwtpushnotif.domain.repository;

import java.util.Collection;

public interface SubscriptionRepository<Type> {

  void save(Type recipient);

  Collection<Type> findAll();

  void remove(Type recipient);

}
