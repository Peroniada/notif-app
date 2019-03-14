package edu.sperek.jwtpushnotif.infrastructure.recipient;

import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.domain.model.entity.Recipient;
import edu.sperek.jwtpushnotif.domain.repository.Sender;

import java.util.Collection;

public class FirebasePushSender implements Sender {

  @Override
  public void send(Message message, Collection<? extends Recipient> subscribers) {}
}
