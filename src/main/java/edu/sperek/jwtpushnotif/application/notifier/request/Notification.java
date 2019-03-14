package edu.sperek.jwtpushnotif.application.notifier.request;

public class Notification {
  public String title;
  public String body;

  public Notification(String title, String body) {
    this.title = title;
    this.body = body;
  }
}
