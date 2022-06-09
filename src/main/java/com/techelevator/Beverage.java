package com.techelevator;

import java.math.BigDecimal;

public class Beverage extends VendingMachineItem{
    public static final String BEVERAGE_MESSAGE = "Cheers Glug, Glug!";
    public Beverage(String name, BigDecimal price, String code, String message){
        super(name, price, code);
        message = BEVERAGE_MESSAGE;
    }
}