package edu.sperek.jwtpushnotif.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "PUBLIC")
public class User {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "password")
  private String password;

  @Column(name = "mail")
  private String mail;

  @Column(name = "has_keys")
  private boolean hasKeys;

  public User() {}

  public User(Long id, String mail) {
    this.id = id;
    this.mail = mail;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
    return "User{" + "id=" + id + ", mail='" + mail + '\'' + '}';
  }
}
