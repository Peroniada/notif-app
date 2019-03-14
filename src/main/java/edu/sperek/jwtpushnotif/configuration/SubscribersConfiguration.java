package edu.sperek.jwtpushnotif.configuration;

import edu.sperek.jwtpushnotif.domain.model.subscription.MailRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import edu.sperek.jwtpushnotif.infrastructure.repository.MockMailSubRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscribersConfiguration {

  @Bean
  SubscriptionRepository<MailRecipient> mailRepository() {
    return new MockMailSubRepository();
  }
}
