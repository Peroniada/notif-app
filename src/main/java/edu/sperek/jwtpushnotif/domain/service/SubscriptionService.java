package edu.sperek.jwtpushnotif.domain.service;

import java.util.Collection;

public interface SubscriptionService<Type> {
  void subscribe(Type recipient);

  void unsubscribe(Type recipient);

  Collection<Type> getSubscribers();

  Type findByRecipientAddress(String address);
}
