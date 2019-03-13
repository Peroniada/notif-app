package edu.sperek.jwtpushnotif.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "push")
public class FirebaseConfigurationProperties {

  private String firebaseKey;
  private String firebaseUrl;

  public String getFirebaseKey() {
    return firebaseKey;
  }

  public void setFirebaseKey(String firebaseKey) {
    this.firebaseKey = firebaseKey;
  }

  public String getFirebaseUrl() {
    return firebaseUrl;
  }

  public void setFirebaseUrl(String firebaseUrl) {
    this.firebaseUrl = firebaseUrl;
  }
}
