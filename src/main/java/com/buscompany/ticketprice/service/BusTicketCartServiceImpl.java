package com.buscompany.ticketprice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.buscompany.ticketprice.model.BusTicketCart;
import com.buscompany.ticketprice.model.LuggageBag;
import com.buscompany.ticketprice.model.Passenger;

@Service
public class BusTicketCartServiceImpl implements BusTicketCartService {

    @Override
    public void updateCartPrices(BusTicketCart cart, BigDecimal basePrice, Integer taxPercentage) {
        cart.setTotalPrice(BigDecimal.ZERO);
        for (Passenger passenger : cart.getPassengers()) {
            BigDecimal discount = null;
            if (passenger.isChild()) {
                discount = new BigDecimal(50);
            }
            BigDecimal ticketPrice = applyDiscountAndTax(basePrice, discount, taxPercentage);
            passenger.setTicketPrice(ticketPrice.setScale(2, RoundingMode.HALF_EVEN));
            for (LuggageBag bag : passenger.getLuggage()) {
                BigDecimal bagPrice = applyDiscountAndTax(basePrice, new BigDecimal(70), taxPercentage);
                bag.setPrice(bagPrice.setScale(2, RoundingMode.HALF_EVEN));
                cart.setTotalPrice(cart.getTotalPrice().add(bag.getPrice()));
            }
            cart.setTotalPrice(cart.getTotalPrice().add(ticketPrice));
        }
        cart.setTotalPrice(cart.getTotalPrice().setScale(2, RoundingMode.HALF_EVEN));
    }

    public static BigDecimal applyDiscountAndTax(BigDecimal basePrice, BigDecimal discount, Integer tax) {
        if (discount == null && tax == null) {
            return basePrice;
        }
        BigDecimal resultPrice = basePrice;
        if (discount != null) {
            resultPrice = resultPrice.multiply(BigDecimal.ONE.subtract(discount.divide(new BigDecimal(100))));
        }

        if (tax != null) {
            resultPrice = resultPrice.multiply(BigDecimal.ONE.add(new BigDecimal(tax).divide(new BigDecimal(100))));
        }

        return resultPrice;
    }

}
