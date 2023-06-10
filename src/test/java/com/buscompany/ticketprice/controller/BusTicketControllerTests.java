package com.buscompany.ticketprice.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.buscompany.ticketprice.model.BusTicketCart;
import com.buscompany.ticketprice.utils.testDataBuilders;

import reactor.core.publisher.Mono;

@SpringBootTest
@AutoConfigureWebTestClient
class BusTicketControllerTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testCartPriceCalculation() {
        webTestClient.post()
        .uri(BusTicketController.API_PATH + BusTicketController.CALCULATE_PATH)
        .body(Mono.just(testDataBuilders.getValidTestCartRequest()), BusTicketCart.class)
        .header("Content-type", "application/json")
        .exchange()
        .expectStatus().isOk()
        .expectHeader().valueEquals("Content-type", "application/json")
        .expectBody()
        .jsonPath("$.passengers").isArray()
        .jsonPath("$.passengers[0].luggage").isArray()
        .jsonPath("$.passengers[0].ticketPrice").isEqualTo(6.05)
        .jsonPath("$.passengers[1].ticketPrice").isEqualTo(12.1)
        .jsonPath("$.passengers[0].luggage[0].price").isEqualTo(3.63)
        .jsonPath("$.passengers[0].luggage[1].price").isEqualTo(3.63)
        .jsonPath("$.passengers[1].luggage[0].price").isEqualTo(3.63)

        .jsonPath("$.totalPrice").isEqualTo(29.04);
    }

    @Test
    void testBadRequestWhenNoBusRoute() {
        webTestClient.post()
        .uri(BusTicketController.API_PATH + BusTicketController.CALCULATE_PATH)
        .body(Mono.just(testDataBuilders.getCartRequestWithoutBusRoute()), BusTicketCart.class)
        .header("Content-type", "application/json")
        .exchange()
        .expectStatus().isBadRequest()
        .expectHeader().valueEquals("Content-type", "application/json")
        .expectBody()
        .jsonPath("$.errors").isArray()
        .jsonPath("$.errors").value(Matchers.containsInAnyOrder("Bus terminal name from must not be blank", "Bus terminal name to must not be blank"));
    }

    @Test
    void testBadRequestWhenNoPassengers() {
        webTestClient.post()
        .uri(BusTicketController.API_PATH + BusTicketController.CALCULATE_PATH)
        .body(Mono.just(testDataBuilders.getCartRequestWithoutPassengers()), BusTicketCart.class)
        .header("Content-type", "application/json")
        .exchange()
        .expectStatus().isBadRequest()
        .expectHeader().valueEquals("Content-type", "application/json")
        .expectBody()
        .jsonPath("$.errors").isArray()
        .jsonPath("$.errors").value(Matchers.containsInAnyOrder("Passengers must not be null"));
    }
}
