package com.techelevator;

import java.math.BigDecimal;

public class Gum extends VendingMachineItem {
    public static final String GUM_MESSAGE = "Chew Chew, Pop!";
    public Gum(String name, BigDecimal price, String code, String GUM_MESSAGE, int quantity){
        super(name, price, code);
        this.message = GUM_MESSAGE;
    }

    @Override
    public String getMessage() {
        return GUM_MESSAGE;
    }

}
