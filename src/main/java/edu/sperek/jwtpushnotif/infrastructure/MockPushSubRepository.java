package edu.sperek.jwtpushnotif.infrastructure;

import edu.sperek.jwtpushnotif.domain.model.subscription.PushRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MockPushSubRepository implements SubscriptionRepository<PushRecipient> {

  private static final Collection<PushRecipient> recipients = new HashSet<>();

  @Override
  public void save(PushRecipient recipient) {
    recipients.add(recipient);
  }

  @Override
  public Collection<PushRecipient> findAll() {
    return recipients;
  }

  @Override
  public void remove(PushRecipient recipient) {
    recipients.remove(recipient);
  }
}
