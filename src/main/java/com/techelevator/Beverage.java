package com.techelevator;

import java.math.BigDecimal;

public class Beverage extends VendingMachineItem{
    private final String BEVERAGE_MESSAGE = "Cheers Glug, Glug!";
    public Beverage(String name, BigDecimal price, int quantity, String code, String message){
        super(name, price, quantity, code);
        message = BEVERAGE_MESSAGE;
    }
}