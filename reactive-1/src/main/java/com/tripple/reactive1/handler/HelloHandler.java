package com.tripple.reactive1.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.*;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class HelloHandler {

  public Mono<ServerResponse> hello(ServerRequest request) {
    return ok().contentType(MediaType.TEXT_PLAIN)
        .body(fromValue("Hello " + request.pathVariable("name")));
  }
}
