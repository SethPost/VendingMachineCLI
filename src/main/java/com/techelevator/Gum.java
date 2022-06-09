package com.techelevator;

import java.math.BigDecimal;

public class Gum extends VendingMachineItem {
    public static final String GUM_MESSAGE = "Chew Chew, Pop!";
    public Gum(String name, BigDecimal price, String code, String message){
        super(name, price, code);
        message = GUM_MESSAGE;
    }

}
