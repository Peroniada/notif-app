package edu.sperek.jwtpushnotif.domain.model.subscription;

import java.util.Objects;

public abstract class Recipient {

  public final String pointer;

  public Recipient(String pointer) {
    this.pointer = pointer;
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
    return pointer.equals(recipient.pointer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pointer);
  }
}
