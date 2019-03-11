package edu.sperek.jwtpushnotif.domain.notifier;

import edu.sperek.jwtpushnotif.domain.model.Message;

public abstract class NotifierDecorator implements Notifier{
  private Notifier tempNotifier;

  public NotifierDecorator(Notifier tempNotifier) {
    this.tempNotifier = tempNotifier;
  }


  @Override
  public void send(Message notification) {
    this.tempNotifier.send(notification);
  }
}
