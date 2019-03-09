package edu.sperek.jwtpushnotif.application;

import edu.sperek.jwtpushnotif.domain.model.subscription.PushRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import edu.sperek.jwtpushnotif.domain.service.SubscriptionService;
import java.util.Collection;

public class PushSubscriptionService implements SubscriptionService<PushRecipient> {

  private final SubscriptionRepository<PushRecipient> repository;

  public PushSubscriptionService(
      SubscriptionRepository<PushRecipient> repository) {
    this.repository = repository;
  }

  @Override
  public void subscribe(PushRecipient recipient) {
    this.repository.save(recipient);
  }

  @Override
  public void unsubscribe(PushRecipient recipient) {
    this.repository.remove(recipient);
  }

  @Override
  public Collection<PushRecipient> getSubscribers() {
    return this.repository.findAll();
  }
}
