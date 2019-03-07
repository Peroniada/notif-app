package edu.sperek.jwtpushnotif.controller;

import edu.sperek.jwtpushnotif.domain.model.User;
import edu.sperek.jwtpushnotif.domain.service.UserService;
import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/addUser")
  ResponseEntity<String> addUser(@RequestBody User user) {
    userService.createUser(user);

    return ResponseEntity.ok("Added user " + user.getMail());
  }

  @GetMapping("/")
  ResponseEntity<Collection<User>> getUsers() {

    return ResponseEntity.ok(userService.getUsers());
  }



}
