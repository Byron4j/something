package org.byron4j.bootaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class Router {
    @Autowired
    private FluxHandler fluxHandler;

    @Bean
    public RouterFunction<ServerResponse> getString(){
        return route(GET("/route"), request -> fluxHandler.test(request));
    }
}
