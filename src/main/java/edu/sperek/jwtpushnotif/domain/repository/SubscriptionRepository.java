package edu.sperek.jwtpushnotif.domain.repository;

import java.util.Collection;

// TODO create two bean methods for generic repositories -> how? xD
public interface SubscriptionRepository<Type> {

  Type save(Type recipient);

  Collection<Type> findAll();

  void delete(Type recipient);

  Type findByRecipientAddress(String address);
}
