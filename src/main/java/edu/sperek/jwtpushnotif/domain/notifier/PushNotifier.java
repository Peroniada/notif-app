package edu.sperek.jwtpushnotif.domain.notifier;

import edu.sperek.jwtpushnotif.HeaderRequestInterceptor;
import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.domain.model.subscription.PushRecipient;
import edu.sperek.jwtpushnotif.domain.repository.SubscriptionRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

public class PushNotifier extends NotifierDecorator {

  @Value("${service.firebase.key}")
  private String firebaseKey;

  @Value("${service.firebase.url}")
  private String firebaseApiUrl;

  private SubscriptionRepository<PushRecipient> repository;

  public PushNotifier(Notifier tempNotifier) {
    super(tempNotifier);
  }

  @Override
  public void send(Message notification) {
    RestTemplate restTemplate = new RestTemplate();
    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + firebaseKey));
    interceptors.add(new HeaderRequestInterceptor("Content-Type", "application.json"));
    restTemplate.setInterceptors(interceptors);

    //TODO Build Create valid notification request to work with firebase api
    restTemplate.postForObject(firebaseApiUrl, notification, String.class);
    super.send(notification);
  }
}