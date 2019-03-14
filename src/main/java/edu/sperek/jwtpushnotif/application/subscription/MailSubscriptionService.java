package edu.sperek.jwtpushnotif.application.subscription;

import edu.sperek.jwtpushnotif.domain.model.entity.MailRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import edu.sperek.jwtpushnotif.domain.service.SubscriptionService;

import java.util.Collection;

// TODO Create Subscription controller for adding mail subscribers
public class MailSubscriptionService implements SubscriptionService<MailRecipient> {

  private SubscriptionRepository<MailRecipient> repository;

  public MailSubscriptionService(SubscriptionRepository<MailRecipient> repository) {
    this.repository = repository;
  }

  @Override
  public void subscribe(MailRecipient recipient) {
    this.repository.save(recipient);
  }

  @Override
  public void unsubscribe(MailRecipient recipient) {
    this.repository.delete(recipient);
  }

  @Override
  public Collection<MailRecipient> getSubscribers() {
    return this.repository.findAll();
  }
}
