package edu.sperek.jwtpushnotif.domain.model;

public class User {

  private String mail;
  private String token;

  public User() {
  }

  public User(String mail, String token) {
    this.mail = mail;
    this.token = token;
  }

  public String getMail() {
    return mail;
  }

  public String getToken() {
    return token;
  }
}
