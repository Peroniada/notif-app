package edu.sperek.jwtpushnotif;

import edu.sperek.jwtpushnotif.application.AndroidPushNotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JwtPushNotifApplication {

  public static void main(String[] args) {
    SpringApplication.run(JwtPushNotifApplication.class, args);
  }

  @Component
  public class CmdRunner implements CommandLineRunner {

    AndroidPushNotificationsService notificationService;

    @Autowired
    public CmdRunner(AndroidPushNotificationsService notificationService) {
      this.notificationService = notificationService;
    }

    @Override
    public void run(String... args) throws Exception {
      System.out.println(notificationService.getFirebaseKey());
    }
  }
}
