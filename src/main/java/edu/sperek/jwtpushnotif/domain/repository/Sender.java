package edu.sperek.jwtpushnotif.domain.repository;

import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.domain.model.subscription.Recipient;
import java.util.Collection;

public interface Sender {

  void send(Message message,
      Collection<? extends Recipient> subscribers);

}
