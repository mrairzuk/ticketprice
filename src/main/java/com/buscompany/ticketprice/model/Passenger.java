package com.buscompany.ticketprice.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Passenger {

    @NotBlank(message = "Name must not be blank")
    String name;
    @NotBlank(message = "Surname must not be blank")
    String surname;

    @NotNull(message = "Birth date must not be null")
    @DateTimeFormat(iso = ISO.DATE)
    Date birthDate;

    @Valid
    List<LuggageBag> luggage = new ArrayList<>();

    BigDecimal ticketPrice;

    public boolean isChild() {
        return Period.between(birthDate.toLocalDate(), LocalDate.now()).getYears() < 18;
    }

}
