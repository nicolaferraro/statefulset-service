package com.example;

import java.net.InetAddress;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * @author nicola
 * @since 25/05/2017
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Component
    public static class Routes extends RouteBuilder {

        public void configure() throws Exception {

            restConfiguration().port(8080);

            rest().get("/")
                    .produces("text/plain")
                    .route()
                    .setBody().constant(InetAddress.getLocalHost().getHostAddress());

        }
    }

}
