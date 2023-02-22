package org.byron4j.bootaction;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class FluxHandler {

    public Mono<ServerResponse> test(ServerRequest serverRequest){
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("This is a WebFlux demo."), String.class);
    }
}
