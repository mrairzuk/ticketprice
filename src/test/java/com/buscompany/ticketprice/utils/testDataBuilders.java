package com.buscompany.ticketprice.utils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.buscompany.ticketprice.model.BusTicketCart;
import com.buscompany.ticketprice.model.LuggageBag;
import com.buscompany.ticketprice.model.Passenger;

public class testDataBuilders {
    public static BusTicketCart getValidTestCartRequest() {
        return BusTicketCart.builder().busTerminalNameFrom("Riga").busTerminalNameTo("Vilnius").passengers(getValidPassengers()).build();
    }

    public static BusTicketCart getCartRequestWithoutBusRoute() {
        return BusTicketCart.builder().passengers(getValidPassengers()).build(); 
    }

    public static BusTicketCart getCartRequestWithoutPassengers() {
        return BusTicketCart.builder().busTerminalNameFrom("Riga").busTerminalNameTo("Vilnius").build();
    }

    private static Set<Passenger> getValidPassengers() {
        List<LuggageBag> luggage1 = new ArrayList<>();
        luggage1.add(getValidLuggageBag());
        luggage1.add(getValidLuggageBag());

        List<LuggageBag> luggage2 = new ArrayList<>();
        luggage2.add(getValidLuggageBag());

        Set<Passenger> passengers = new HashSet<>();
        passengers.add(Passenger.builder().name("John2").surname("Doe2").birthDate(Date.valueOf("2007-06-08")).luggage(luggage1).build());
        passengers.add(Passenger.builder().name("John").surname("Doe").birthDate(Date.valueOf("2000-06-08")).luggage(luggage2).build());

        return passengers;
    }

    private static LuggageBag getValidLuggageBag() {
        return LuggageBag.builder().weight(20d).height(10).width(10).length(50).build();
    }
}
