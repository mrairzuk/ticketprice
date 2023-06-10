package com.buscompany.ticketprice.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LuggageBag {

    @NotNull(message = "Height must not be null")
    @Max(value = 35, message = "Max height is 35 cm")
    Integer height;

    @NotNull(message = "Width must not be null")
    @Max(value = 25, message = "Max height is 25 cm")
    Integer width;

    @NotNull(message = "Length must not be null")
    @Max(value = 55, message = "Max height is 55 cm")
    Integer length;

    @NotNull(message = "Weight must not be null")
    @Max(value = 20, message = "Max weight is 20 kg")
    Double weight;

    BigDecimal price;
}
