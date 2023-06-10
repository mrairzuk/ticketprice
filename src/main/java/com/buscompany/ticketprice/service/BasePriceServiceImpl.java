package com.buscompany.ticketprice.service;

import java.math.BigDecimal;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("production")
@Service
public class BasePriceServiceImpl implements BasePriceService {

    @Override
    public BigDecimal getBasePrice(String from, String to) {
        // TODO: Add actual connection to base price API
        throw new UnsupportedOperationException("Unimplemented method 'getBasePrice'");
    }

}
