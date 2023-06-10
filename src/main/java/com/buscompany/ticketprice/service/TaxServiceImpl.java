package com.buscompany.ticketprice.service;

import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("production")
@Service
public class TaxServiceImpl implements TaxService {

    @Override
    public Map<String, Integer> getTodayTaxList() {
        // TODO: Add actual connection to today tax API
        throw new UnsupportedOperationException("Unimplemented method 'getTodayTaxList'");
    }

}
