package com.mayank.Spring_config2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
  @Value("${my.greeting}")
  private String greetingMessage;

  @GetMapping("/greeting")
  public String greeting() {
    return greetingMessage;
  }
}
