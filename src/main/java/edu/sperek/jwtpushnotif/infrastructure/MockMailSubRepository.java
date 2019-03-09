package edu.sperek.jwtpushnotif.infrastructure;

import edu.sperek.jwtpushnotif.domain.model.subscription.MailRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import java.util.Collection;
import java.util.HashSet;

public class MockMailSubRepository implements SubscriptionRepository<MailRecipient> {

  private final static Collection<MailRecipient> recipients = new HashSet<>();

  @Override
  public void save(MailRecipient recipient) {

  }

  @Override
  public Collection<MailRecipient> findAll() {
    return null;
  }

  @Override
  public void remove(MailRecipient recipient) {

  }
}
