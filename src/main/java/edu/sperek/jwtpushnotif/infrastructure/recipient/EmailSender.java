package edu.sperek.jwtpushnotif.infrastructure.recipient;

import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.domain.model.entity.Recipient;
import edu.sperek.jwtpushnotif.domain.repository.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class EmailSender implements Sender {

  private final MailSender javaMailSender;

  @Autowired
  public EmailSender(MailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @Override
  public void send(Message notification, Collection<? extends Recipient> subscribers) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(
        subscribers.stream().map(subscriber -> subscriber.recipientAddress).toArray(String[]::new));
    message.setText(notification.getMessage());
    message.setSubject(notification.getSubject());
    long start = System.currentTimeMillis();
    //    javaMailSender.send(message);
    System.out.println("sending mail took : " + (System.currentTimeMillis() - start));
  }
}
