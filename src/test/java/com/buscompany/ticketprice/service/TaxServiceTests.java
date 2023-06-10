package com.buscompany.ticketprice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

@SpringBootTest
public class TaxServiceTests {
    
    @Autowired
    TaxService taxService;

    @Test
    void returnsTaxMap() {
        Map<String, Integer> todayTaxes = taxService.getTodayTaxList();

        assertFalse(todayTaxes.isEmpty());
        assertTrue(todayTaxes.containsKey("LV"));
    }
}
