package edu.sperek.jwtpushnotif.infrastructure.repository;

import edu.sperek.jwtpushnotif.domain.model.entity.MailRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;

import java.util.Collection;
import java.util.HashSet;

public class MockMailSubRepository implements SubscriptionRepository<MailRecipient> {

  private static final Collection<MailRecipient> recipients = new HashSet<>();

  public MockMailSubRepository() {
    recipients.add(new MailRecipient("sebastianperek@gmail.com", 1L));
    recipients.add(new MailRecipient("blodoc17@gmail.com", 2L));
    recipients.add(new MailRecipient("karolbiczuk@gmail.com", 3L));
  }

  @Override
  public MailRecipient save(MailRecipient recipient) {
    recipients.add(recipient);
    return recipient;
  }

  @Override
  public Collection<MailRecipient> findAll() {
    return recipients;
  }

  @Override
  public void delete(MailRecipient recipient) {}
}
