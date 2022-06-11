package com.techelevator;

import java.math.BigDecimal;

public class Candy extends VendingMachineItem{
    public static final String CANDY_MESSAGE = "Munch Munch, Mmm-Good!";
    public Candy(String name, BigDecimal price, String code, String CANDY_MESSAGE, int quantity){
        super(name, price, code);
        this.message = CANDY_MESSAGE;
    }

    @Override
    public String getMessage() {
        return CANDY_MESSAGE;
    }
}