package edu.sperek.jwtpushnotif.infrastructure.repository;

import edu.sperek.jwtpushnotif.domain.model.entity.MailRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2MailRecipientRepository
    extends JpaRepository<MailRecipient, Long>, SubscriptionRepository<MailRecipient> {

  MailRecipient findByRecipientAddress(String recipientAddress);
}
