package edu.sperek.jwtpushnotif.infrastructure.repository;

import edu.sperek.jwtpushnotif.domain.model.subscription.MailRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import java.util.Collection;
import java.util.HashSet;

public class MockMailSubRepository implements SubscriptionRepository<MailRecipient> {

  private final static Collection<MailRecipient> recipients = new HashSet<>();

  public MockMailSubRepository() {
    recipients.add(new MailRecipient("sebastianperek@gmail.com"));
    recipients.add(new MailRecipient("blodoc17@gmail.com"));
    recipients.add(new MailRecipient("karolbiczuk@gmail.com"));
  }

  @Override
  public void save(MailRecipient recipient) {
    recipients.add(recipient);
  }

  @Override
  public Collection<MailRecipient> findAll() {
    return recipients;
  }

  @Override
  public void remove(MailRecipient recipient) {

  }
}