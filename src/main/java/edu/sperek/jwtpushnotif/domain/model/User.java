package edu.sperek.jwtpushnotif.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long userId;
  
  private String password;

  private String mail;
  
  private boolean hasKeys;

  public User() {}

  public User(Long userId, String mail) {
    this.userId = userId;
    this.mail = mail;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public boolean isHasKeys() {
    return hasKeys;
  }

  public void setHasKeys(boolean hasKeys) {
    this.hasKeys = hasKeys;
  }

  @Override
  public String toString() {
    return "User{" + "userId=" + userId + ", mail='" + mail + '\'' + '}';
  }
}
