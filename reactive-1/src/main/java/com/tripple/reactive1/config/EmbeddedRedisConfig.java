package com.tripple.reactive1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class EmbeddedRedisConfig {

  @Value("${spring.redis.port}")
  private int redisPort;

  private RedisServer redisServer;

  @PostConstruct
  public void redisServer() {
//    redisServer = new RedisServer(6378);
    redisServer = RedisServer.builder()
        .port(redisPort)
        .setting("maxmemory 128M")
        .build();
    try {
      redisServer.start();
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
    }

  }

  @PreDestroy
  public void stopRedis() {
    redisServer.stop();
  }
}
