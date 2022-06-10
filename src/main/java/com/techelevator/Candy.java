package com.techelevator;

import java.math.BigDecimal;

public class Candy extends VendingMachineItem{
    public static final String CANDY_MESSAGE = "Munch Munch, Mmm-Good!";
    public Candy(String name, BigDecimal price, String code, String message, int quantity){
        super(name, price, code);
        message = CANDY_MESSAGE;
    }
}