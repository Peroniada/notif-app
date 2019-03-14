package edu.sperek.jwtpushnotif.configuration;

import edu.sperek.jwtpushnotif.application.subscription.MailSubscriptionService;
import edu.sperek.jwtpushnotif.domain.model.entity.MailRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import edu.sperek.jwtpushnotif.domain.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscribersConfiguration {

  private final SubscriptionRepository<MailRecipient> subscriptionRepository;

  @Autowired
  public SubscribersConfiguration(SubscriptionRepository<MailRecipient> subscriptionRepository) {
    this.subscriptionRepository = subscriptionRepository;
  }

  @Bean
  SubscriptionService<MailRecipient> mailSubscriptionService() {
    return new MailSubscriptionService(subscriptionRepository);
  }
}
