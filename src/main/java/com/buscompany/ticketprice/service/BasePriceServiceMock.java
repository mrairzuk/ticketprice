package com.buscompany.ticketprice.service;

import java.math.BigDecimal;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({ "dev", "default" })
@Service
public class BasePriceServiceMock implements BasePriceService {

    @Override
    public BigDecimal getBasePrice(String from, String to) {
        return new BigDecimal(10);
    }

}
