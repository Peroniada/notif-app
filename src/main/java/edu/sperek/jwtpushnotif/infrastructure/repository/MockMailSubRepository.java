package edu.sperek.jwtpushnotif.infrastructure.repository;

import edu.sperek.jwtpushnotif.domain.model.entity.MailRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class MockMailSubRepository implements SubscriptionRepository<MailRecipient> {

  private static final Collection<MailRecipient> recipients = new HashSet<>();

  public MockMailSubRepository() {
    recipients.add(new MailRecipient("sebastianperek@gmail.com"));
    recipients.add(new MailRecipient("blodoc17@gmail.com"));
    recipients.add(new MailRecipient("karolbiczuk@gmail.com"));
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

  @Override
  public MailRecipient findByRecipientAddress(String address) {
    final String noSuchAddress = "siema@gmail.com";
    if(noSuchAddress.equals(address)) {
      throw new NoSuchElementException("No such address");
    }
    return new MailRecipient(address);
  }
}
