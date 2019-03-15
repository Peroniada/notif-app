package edu.sperek.jwtpushnotif.controller;

import edu.sperek.jwtpushnotif.domain.model.entity.AppUser;
import edu.sperek.jwtpushnotif.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/addUser")
  ResponseEntity<String> addUser(@RequestBody AppUser appUser) {
    userService.createUser(appUser);

    return ResponseEntity.ok("Added appUser " + appUser.getMail());
  }

  @GetMapping("/")
  ResponseEntity<Collection<AppUser>> getUsers() {

    return ResponseEntity.ok(userService.getUsers());
  }

  @PostMapping("/sign-up")
  ResponseEntity<String> signpUp(@RequestBody AppUser appUser){
    userService.singUp(appUser);

    return ResponseEntity.ok("User sign up " + appUser.getMail());
  }
}
