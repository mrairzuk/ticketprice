package com.buscompany.ticketprice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buscompany.ticketprice.model.BusTicketCart;
import com.buscompany.ticketprice.service.BasePriceService;
import com.buscompany.ticketprice.service.BusTicketCartService;
import com.buscompany.ticketprice.service.TaxService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class BusTicketController {

    public static final String API_PATH = "/bus/ticket";
    public static final String CALCULATE_PATH = "/calculate";


    private final BasePriceService basePriceService;
    private final TaxService taxService;
    private final BusTicketCartService busTicketCartService;

    @PostMapping(API_PATH + CALCULATE_PATH)
    public Mono<BusTicketCart> calculateBusTicketPrice(@Valid @RequestBody BusTicketCart busTicketCart) {
        return Mono.fromCallable(() -> {
            BigDecimal basePrice = basePriceService.getBasePrice(busTicketCart.getBusTerminalNameFrom(),
                    busTicketCart.getBusTerminalNameTo());
            Integer taxPercentage = taxService.getTodayTaxList().get("LV"); // TODO: Resolve tax from bus route
            busTicketCartService.updateCartPrices(busTicketCart, basePrice, taxPercentage);
            return busTicketCart;
        });

    }

}
