package edu.sperek.jwtpushnotif.application;

import edu.sperek.jwtpushnotif.HeaderRequestInterceptor;
import edu.sperek.jwtpushnotif.domain.service.NotificationService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AndroidPushNotificationsService implements NotificationService {

  @Value("${service.firebase.key}")
  private String firebaseKey;
  @Value("${service.firebase.url}")
  private String firebaseApiUrl;

  @Override
  @Async
  public CompletableFuture<?> send(HttpEntity<String> message) {
    RestTemplate restTemplate = new RestTemplate();
    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + firebaseKey));
    interceptors.add(new HeaderRequestInterceptor("Content-Type", "application.json"));
    restTemplate.setInterceptors(interceptors);

    String firebaseResponse = restTemplate.postForObject(firebaseApiUrl, message, String.class);

    return CompletableFuture.completedFuture(firebaseResponse);
  }

  public String getFirebaseKey() {
    return firebaseKey;
  }
}
