package edu.sperek.jwtpushnotif.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class Recipient {

  @Column(name = "recipient_address")
  public String recipientAddress;

  public Recipient() {
  }

  public Recipient(String recipientAddress) {
    this.recipientAddress = recipientAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return recipientAddress.equals(recipient.recipientAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipientAddress);
  }
}
