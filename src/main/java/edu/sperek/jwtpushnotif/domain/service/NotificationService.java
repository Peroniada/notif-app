package edu.sperek.jwtpushnotif.domain.service;

import java.util.concurrent.CompletableFuture;
import org.springframework.http.HttpEntity;

public interface NotificationService {

  CompletableFuture<?> send(HttpEntity<String> message);

}
