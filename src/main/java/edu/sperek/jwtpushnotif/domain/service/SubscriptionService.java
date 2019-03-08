package edu.sperek.jwtpushnotif.domain.service;

public interface SubscriptionService {
  void subscribeMail(String mail);
  void subscribePush(String token);


}
