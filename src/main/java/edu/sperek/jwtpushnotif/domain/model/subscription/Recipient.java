package edu.sperek.jwtpushnotif.domain.model.subscription;

import java.util.Objects;

public abstract class Recipient {

  public final String recipientId;

  public Recipient(String recipientId) {
    this.recipientId = recipientId;
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
    return recipientId.equals(recipient.recipientId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipientId);
  }
}
