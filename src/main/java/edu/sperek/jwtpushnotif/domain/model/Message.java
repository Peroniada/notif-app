package edu.sperek.jwtpushnotif.domain.model;

public class Message {

  private String subject;
  private String message;

  public Message(String subject, String message) {
    this.subject = subject;
    this.message = message;
  }

  public String getSubject() {
    return this.subject;
  }
  public String getMessage() {
    return this.message;
  }
}
