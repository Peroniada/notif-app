package edu.sperek.jwtpushnotif.domain.service;

import edu.sperek.jwtpushnotif.domain.model.Message;


public interface NotificationService {
  void send(Message message);

}
