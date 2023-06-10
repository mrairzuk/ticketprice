package com.buscompany.ticketprice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({ "dev", "default" })
@Service
public class TaxServiceMock implements TaxService {

    @Override
    public Map<String, Integer> getTodayTaxList() {
        Map<String, Integer> taxList = new HashMap<>();
        taxList.put("LV", 21);
        taxList.put("LT", 21);
        taxList.put("EE", 20);
        taxList.put("PL", 23);
        taxList.put("FI", 24);
        taxList.put("SE", 25);
        return taxList;
    }

}
