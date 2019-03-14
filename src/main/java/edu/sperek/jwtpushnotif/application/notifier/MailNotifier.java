package edu.sperek.jwtpushnotif.application.notifier;

import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.domain.model.entity.MailRecipient;
import edu.sperek.jwtpushnotif.domain.model.entity.Recipient;
import edu.sperek.jwtpushnotif.domain.repository.Sender;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;

public class MailNotifier extends NotifierDecorator {

  private SubscriptionRepository<MailRecipient> repository;

  private Sender sender;

  @Value("${spring.mail.username}")
  private String mail;

  @Autowired
  public MailNotifier(
      Notifier tempNotifier, SubscriptionRepository<MailRecipient> repository, Sender sender) {
    super(tempNotifier);
    this.repository = repository;
    this.sender = sender;
  }

  @Override
  public void send(Message notification) {
    final Collection<MailRecipient> subscribers = repository.findAll();
    sendMessage(notification, subscribers);
    super.send(notification);
  }

  private void sendMessage(Message notification, Collection<? extends Recipient> subscribers) {
    System.out.println("Sending Mail");
    sender.send(notification, subscribers);
  }
}
