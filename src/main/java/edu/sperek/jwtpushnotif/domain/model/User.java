package edu.sperek.jwtpushnotif.domain.model;

import java.util.UUID;

public class User {

  private UUID userId;
  private String mail;
  private String token;

  public User() {}

  public User(UUID userId, String mail, String token) {
    this.userId = userId;
    this.mail = mail;
    this.token = token;
  }

  public UUID getUserId() {
    return userId;
  }

  public String getMail() {
    return mail;
  }

  public String getToken() {
    return token;
  }
}
