package edu.sperek.jwtpushnotif.controller;

import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.domain.model.entity.MailRecipient;
import edu.sperek.jwtpushnotif.domain.service.NotificationService;
import edu.sperek.jwtpushnotif.domain.service.SubscriptionService;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

  private NotificationService notificationService;
  private SubscriptionService<MailRecipient> mailSubscriptionService;

  public NotificationController(
      NotificationService notificationService,
      SubscriptionService<MailRecipient> mailSubscriptionService) {
    this.notificationService = notificationService;
    this.mailSubscriptionService = mailSubscriptionService;
  }

  @GetMapping("/greeting")
  public ResponseEntity<String> getHelloWorld() {
    return new ResponseEntity<>("siema", HttpStatus.OK);
  }

  @PostMapping("/office/open")
  public ResponseEntity<String> notifyOfficeOpen() {

    final String messageText = "Biuro jest otwarte, zapraszamy";
    final String messageSubject = "Biuro zostało otwarte";
    Message message = new Message(messageSubject, messageText);
    notificationService.send(message);

    return new ResponseEntity<>("siema", HttpStatus.OK);
  }

  @PostMapping("/subscribe/mail")
  public ResponseEntity<?> subscribeToMail(@RequestBody AddressRequest request) {
    mailSubscriptionService.subscribe(new MailRecipient(request.address));
    return ResponseEntity.ok("Subscribed");
  }

  @PostMapping("/unsubscribe/mail")
  public ResponseEntity<?> unsubscribeFromMail(@RequestBody AddressRequest request) {
    final MailRecipient mailRecipient = mailSubscriptionService
        .findByRecipientAddress(request.address);
    final MailRecipient nullableRecipient = Optional.ofNullable(mailRecipient)
        .orElseThrow(() -> new NoSuchElementException("There is no such recipient"));
    mailSubscriptionService.unsubscribe(nullableRecipient);
    return ResponseEntity.ok("Unsubscribed");
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleNoSuchRecipient() {
    return new ResponseEntity<>("No such recipient", HttpStatus.NOT_FOUND);
  }


}
