package edu.sperek.jwtpushnotif.infrastructure;

import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.domain.model.subscription.Recipient;
import edu.sperek.jwtpushnotif.domain.repository.Sender;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements Sender {

  private final MailSender javaMailSender;

  @Autowired
  public EmailSender(MailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @Override
  public void send(Message notification,
      Collection<? extends Recipient> subscribers) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(
        subscribers.stream().map(subscriber -> subscriber.recipientId).toArray(String[]::new));
    message.setText(notification.getMessage());
    message.setSubject(notification.getSubject());
    javaMailSender.send(message);
  }
}
