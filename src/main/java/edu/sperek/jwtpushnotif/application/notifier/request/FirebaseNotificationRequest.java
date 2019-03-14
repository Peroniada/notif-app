package edu.sperek.jwtpushnotif.application.notifier.request;

public class FirebaseNotificationRequest {
  public String to;
  public Notification notification;

  public FirebaseNotificationRequest(String to,
      Notification notification) {
    this.to = to;
    this.notification = notification;
  }
}
