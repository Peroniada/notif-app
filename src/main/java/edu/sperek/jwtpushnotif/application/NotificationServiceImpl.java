package edu.sperek.jwtpushnotif.application;

import edu.sperek.jwtpushnotif.application.notifier.Notifier;
import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.domain.service.NotificationService;
import org.springframework.http.HttpEntity;

public class NotificationServiceImpl implements NotificationService {

  private final Notifier notifier;

  public NotificationServiceImpl(Notifier notifier) {
    this.notifier = notifier;
  }


  @Override
  public void send(Message message) {
    notifier.send(message);
  }
}

