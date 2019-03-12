package edu.sperek.jwtpushnotif.controller;

import edu.sperek.jwtpushnotif.domain.model.Message;
import edu.sperek.jwtpushnotif.domain.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

  private NotificationService notificationService;

  public NotificationController(
      NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @GetMapping("/greeting")
  public ResponseEntity<String> getHelloWorld() {
    return new ResponseEntity<>("siema", HttpStatus.OK);
  }

  @PostMapping("/office/open")
  public ResponseEntity<String> notifyOfficeOpen(@RequestBody Message message) {

    notificationService.send(message);

    return new ResponseEntity<>("siema", HttpStatus.OK);
  }


}
