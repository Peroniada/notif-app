package edu.sperek.jwtpushnotif.domain.notifier;

import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.domain.model.subscription.MailRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailNotifier extends NotifierDecorator {

  private SubscriptionRepository<MailRecipient> repository;


  public MailNotifier(Notifier tempNotifier, SubscriptionRepository<MailRecipient> repository) {
    super(tempNotifier);
    this.repository = repository;
  }

  @Override
  public void send(Message notification) {
    final Collection<MailRecipient> subscribers = repository.findAll();
    sendMessage(notification, subscribers);
    super.send(notification);
  }

  private void sendMessage(Message notification, Collection<MailRecipient> subscribers) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(
        subscribers.stream()
            .map(subscriber -> subscriber.pointer).toArray(String[]::new));
    message.setSubject(notification.getSubject());
    message.setText(notification.getMessage());
    JavaMailSender sender = new JavaMailSenderImpl();
    sender.send(message);
  }
}
