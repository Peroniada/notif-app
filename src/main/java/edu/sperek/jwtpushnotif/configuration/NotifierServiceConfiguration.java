package edu.sperek.jwtpushnotif.configuration;

import edu.sperek.jwtpushnotif.application.NotificationServiceImpl;
import edu.sperek.jwtpushnotif.application.notifier.BaseNotifier;
import edu.sperek.jwtpushnotif.application.notifier.MailNotifier;
import edu.sperek.jwtpushnotif.application.notifier.PushNotifier;
import edu.sperek.jwtpushnotif.domain.model.subscription.MailRecipient;
import edu.sperek.jwtpushnotif.domain.repository.Sender;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import edu.sperek.jwtpushnotif.domain.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class NotifierServiceConfiguration {

  private final SubscriptionRepository<MailRecipient> mailRepository;
  private final Sender mailSender;
  private final FirebaseConfigurationProperties firebaseProperties;

  @Autowired
  public NotifierServiceConfiguration(
      SubscriptionRepository<MailRecipient> mailRepository,
      Sender mailSender,
      FirebaseConfigurationProperties firebaseProperties) {
    this.mailRepository = mailRepository;
    this.mailSender = mailSender;
    this.firebaseProperties = firebaseProperties;
  }

  @Bean
  public NotificationService notificationService() {
    return new NotificationServiceImpl(
        new MailNotifier(new PushNotifier(new BaseNotifier(), firebaseProperties), mailRepository, mailSender));
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

}
