package edu.sperek.jwtpushnotif.domain.model.subscription;

public class PushRecipient extends Recipient {

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  public PushRecipient(String pointer) {
    super(pointer);


  }
}
