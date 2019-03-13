package edu.sperek.jwtpushnotif.configuration;

import edu.sperek.jwtpushnotif.domain.model.subscription.MailRecipient;
import edu.sperek.jwtpushnotif.domain.model.subscription.PushRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import edu.sperek.jwtpushnotif.infrastructure.repository.MockMailSubRepository;
import edu.sperek.jwtpushnotif.infrastructure.repository.MockPushSubRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscribersConfiguration {

  @Bean
  SubscriptionRepository<MailRecipient> mailRepository() {
    return new MockMailSubRepository();
  }

  @Bean
  SubscriptionRepository<PushRecipient> pushRepository() {
    return new MockPushSubRepository();
  }
}
