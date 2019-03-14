package edu.sperek.jwtpushnotif.configuration;

import edu.sperek.jwtpushnotif.domain.model.entity.MailRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscribersConfiguration {

  @Autowired private SubscriptionRepository<MailRecipient> subscriptionRepository;

  @Bean
  SubscriptionRepository<MailRecipient> mailRepository() {
    return subscriptionRepository;
  }
}
