package com.buscompany.ticketprice.model;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusTicketCart {

    @NotBlank(message = "Bus terminal name from must not be blank")
    String busTerminalNameFrom;

    @NotBlank(message = "Bus terminal name to must not be blank")
    String busTerminalNameTo;

    @Valid
    @NotNull(message = "Passengers must not be null")
    @Size(min = 1, message = "Passenger count must be at least 1")
    Set<Passenger> passengers;

    BigDecimal totalPrice;

}
