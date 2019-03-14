package edu.sperek.jwtpushnotif.application.notifier;

import edu.sperek.jwtpushnotif.HeaderRequestInterceptor;
import edu.sperek.jwtpushnotif.application.notifier.request.Notification;
import edu.sperek.jwtpushnotif.configuration.FirebaseConfigurationProperties;
import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.application.notifier.request.FirebaseNotificationRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

public class PushNotifier extends NotifierDecorator {

  private FirebaseConfigurationProperties properties;

  public PushNotifier(Notifier tempNotifier, FirebaseConfigurationProperties properties) {
    super(tempNotifier);
    this.properties = properties;
  }

  @Override
  public void send(Message notification) {
    System.out.println("Sending Push");
    System.out.println(properties.getFirebaseUrl());
    RestTemplate restTemplate = new RestTemplate();
    System.out.println("SERVER KEY: " + properties.getFirebaseKey());
    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(
        new HeaderRequestInterceptor("Authorization", "key=" + properties.getFirebaseKey()));
    interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
    restTemplate.setInterceptors(interceptors);
    final String to = "/topics/all";
    final Notification firebaseNotification =
        new Notification(notification.getSubject(), notification.getMessage());
    FirebaseNotificationRequest request = new FirebaseNotificationRequest(to, firebaseNotification);
    // TODO Refactor This method do be less messy
        ResponseEntity<?> entity = restTemplate.postForEntity(properties.getFirebaseUrl(), request, String.class);
    System.out.println(entity);
    super.send(notification);
  }
}
