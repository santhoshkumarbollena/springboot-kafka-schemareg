package io.confluent.developer.spring.avro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.confluent.developer.User;
import java.util.*;

@RestController
@RequestMapping(value = "/user")
public class KafkaController {

  private final Producer producer;

  @Autowired
  KafkaController(Producer producer) {
    this.producer = producer;
  }

  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("age") Integer age) {
	  ArrayList<String> ai=new ArrayList<>();
	  ai.add("asda@g");
	  ai.add("asdas@y");
	  ArrayList<Integer> ai2=new ArrayList<>();
	  ai2.add(77);
	  ai2.add(99);
    this.producer.sendMessage(new User(name, age,ai,ai2));
  }
}