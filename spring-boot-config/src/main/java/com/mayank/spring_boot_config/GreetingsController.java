package com.mayank.spring_boot_config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RefreshScope
public class GreetingsController {

  @Value("${my.greeting : default value}")
  private String greetingMessage;

  @Value("some static message")
  private String staticMessage;

  @Value("${my.list.values}")
  private List<String> listValues;

  @Value("#{${dbValues}}") //# here treats it as
  private Map<String, String> dbValues;

  @Autowired
  private Environment environment;

  @Autowired
  private DBSettings dbSettings;

  @GetMapping("/greeting")
  public String greeting() {
    return dbSettings.getConnection() + dbSettings.getHost() + greetingMessage + staticMessage + listValues.toString();
  }

  @GetMapping("/envdetails")
  public String envDetails() {
    return environment.toString();
  }
}
