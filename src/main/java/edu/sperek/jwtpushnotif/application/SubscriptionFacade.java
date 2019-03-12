package edu.sperek.jwtpushnotif.application;

import edu.sperek.jwtpushnotif.application.subscription.MailSubscriptionService;
import edu.sperek.jwtpushnotif.application.subscription.PushSubscriptionService;
import edu.sperek.jwtpushnotif.domain.model.subscription.MailRecipient;
import edu.sperek.jwtpushnotif.domain.model.subscription.PushRecipient;
import java.util.Collection;

public class SubscriptionFacade {
  private MailSubscriptionService mailSubscriptionService;
  private PushSubscriptionService pushSubscriptionService;

  public SubscriptionFacade(
      MailSubscriptionService mailSubscriptionService,
      PushSubscriptionService pushSubscriptionService) {
    this.mailSubscriptionService = mailSubscriptionService;
    this.pushSubscriptionService = pushSubscriptionService;
  }

  public void subscribeMailRecipient(MailRecipient recipient) {
    this.mailSubscriptionService.subscribe(recipient);
  }

  public void unsubscribeMailRecipient(MailRecipient recipient) {
    this.mailSubscriptionService.unsubscribe(recipient);
  }

  public void subscribePushRecipient(PushRecipient recipient) {
    this.pushSubscriptionService.subscribe(recipient);
  }

  public void unsubscribePushRecipient(PushRecipient recipient) {
    this.pushSubscriptionService.unsubscribe(recipient);
  }

  public Collection<MailRecipient> getMailSubscribers() {
    return this.mailSubscriptionService.getSubscribers();
  }

  public Collection<PushRecipient> getPushSubscribers() {
    return this.pushSubscriptionService.getSubscribers();
  }
}
