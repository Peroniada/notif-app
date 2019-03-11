package edu.sperek.jwtpushnotif.domain.repository;

import java.util.Collection;

//TODO create two bean methods for generic repositories -> how? xD
public interface SubscriptionRepository<Type> {

  void save(Type recipient);

  Collection<Type> findAll();

  void remove(Type recipient);

}
