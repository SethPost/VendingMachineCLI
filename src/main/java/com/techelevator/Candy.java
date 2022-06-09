package com.techelevator;

import java.math.BigDecimal;

public class Candy extends VendingMachineItem{
    private final String CANDY_MESSAGE = "Munch Munch, Mmm-Good!";
    public Candy(String name, BigDecimal price, int quantity, String code, String message){
        super(name, price, quantity, code);
        message = CANDY_MESSAGE;
    }
}