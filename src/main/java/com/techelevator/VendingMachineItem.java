package com.techelevator;

import java.math.BigDecimal;

public abstract class VendingMachineItem {
    private String name;
    private BigDecimal price;
    private int quantity;
    private String code;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public VendingMachineItem(String name, BigDecimal price, int quantity, String code) {
        this.name = name;
        this.price = price;
        this. quantity = quantity;
        this.code = code;

    }

    public VendingMachineItem() {

    }



}