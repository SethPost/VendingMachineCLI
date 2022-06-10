package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineTests {
    private VendingMachine vendingMachine = new VendingMachine(new BigDecimal("0.00"));

    @Test
    public void test_display_items() {

    }

    @Test
    public void test_feed_money() {
        BigDecimal amountAdded = new BigDecimal("1.00");
        vendingMachine.feedMoney(amountAdded);
        Assert.assertEquals(new BigDecimal("1.00"), vendingMachine.getCurrentMoneyProvided());
    }

    @Test
    public void test_feed_money_3_times() {
        BigDecimal amountAdded = new BigDecimal("1.00");
        BigDecimal expectedResult = new BigDecimal("3.00");
        vendingMachine.feedMoney(amountAdded);
        vendingMachine.feedMoney(amountAdded);
        vendingMachine.feedMoney(amountAdded);
        Assert.assertEquals(expectedResult, vendingMachine.getCurrentMoneyProvided());
    }

    @Test
    public void test_feed_money_ten_dollars() {
        BigDecimal amountAdded = new BigDecimal("10.00");
        BigDecimal expectedResult = new BigDecimal("10.00");
        vendingMachine.feedMoney(amountAdded);
        Assert.assertEquals(expectedResult, vendingMachine.getCurrentMoneyProvided());
    }


}
