package com.buscompany.ticketprice.service;

import java.math.BigDecimal;

public interface BasePriceService {
    public BigDecimal getBasePrice(String from, String to);
}
