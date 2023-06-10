package com.buscompany.ticketprice.service;

import java.math.BigDecimal;

import com.buscompany.ticketprice.model.BusTicketCart;

public interface BusTicketCartService {
    public void updateCartPrices(BusTicketCart cart, BigDecimal basePrice, Integer taxPercentage);
}
