package edu.sperek.jwtpushnotif.application.notifier;

import edu.sperek.jwtpushnotif.HeaderRequestInterceptor;
import edu.sperek.jwtpushnotif.configuration.FirebaseConfigurationProperties;
import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.domain.model.subscription.PushRecipient;
import edu.sperek.jwtpushnotif.application.notifier.request.FirebaseNotificationRequest;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

public class PushNotifier extends NotifierDecorator {

  private SubscriptionRepository<PushRecipient> repository;

  private FirebaseConfigurationProperties properties;

  public PushNotifier(
      Notifier tempNotifier,
      SubscriptionRepository<PushRecipient> repository,
      FirebaseConfigurationProperties properties) {
    super(tempNotifier);
    this.properties = properties;
    this.repository = repository;
  }

  @Override
  public void send(Message notification) {
    System.out.println("Sending Push");
    System.out.println(properties.getFirebaseUrl());
    RestTemplate restTemplate = new RestTemplate();
    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(
        new HeaderRequestInterceptor("Authorization", "key=" + properties.getFirebaseKey()));
    interceptors.add(new HeaderRequestInterceptor("Content-Type", "application.json"));
    restTemplate.setInterceptors(interceptors);
    FirebaseNotificationRequest request = new FirebaseNotificationRequest();
    // TODO Build Create valid notification request to work with firebase api
    //    restTemplate.postForObject(firebaseApiUrl, notification, String.class);
    super.send(notification);
  }
}
