package com.techelevator;

import java.math.BigDecimal;

public abstract class VendingMachineItem {
    private String name;
    private BigDecimal price;
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

    public VendingMachineItem(String name, BigDecimal price, String code) {
        this.name = name;
        this.price = price;
        this.code = code;

    }

    public VendingMachineItem() {

    }



}