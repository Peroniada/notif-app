package edu.sperek.jwtpushnotif.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "PUBLIC")
public class AppUser {

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

  public AppUser() {}

  public AppUser(Long id, String mail) {
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
    return "AppUser{" + "id=" + id + ", mail='" + mail + '\'' + '}';
  }
}
