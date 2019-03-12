package edu.sperek.jwtpushnotif.application.notifier;

import edu.sperek.jwtpushnotif.domain.model.Message;

public interface Notifier {
  void send(Message notification);

}
