package edu.sperek.jwtpushnotif.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mail_recipient")
public class MailRecipient extends Recipient {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  public MailRecipient(String recipientAddress, Long id) {
    super(recipientAddress);
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
