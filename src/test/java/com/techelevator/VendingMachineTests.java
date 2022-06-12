package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineTests {
    private VendingMachine vendingMachine = new VendingMachine(new BigDecimal("0.00"));

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

    @Test
    public void test_select_product_valid_code(){
        VendingMachine testVendingMachine = new VendingMachine(new BigDecimal("10.00"));
        testVendingMachine.readInventoryFile();
        BigDecimal testBalance = new BigDecimal(String.valueOf(testVendingMachine.selectProduct("A1")));
        Assert.assertEquals(new BigDecimal("6.95"), testBalance);
    }

    @Test
    public void test_select_product_invalid_code(){
        VendingMachine testVendingMachine = new VendingMachine(new BigDecimal("10.00"));
        testVendingMachine.readInventoryFile();
        BigDecimal testBalance = new BigDecimal(String.valueOf(testVendingMachine.selectProduct("Z1")));
        Assert.assertEquals(new BigDecimal("10.00"), testBalance);
    }

    @Test
    public void test_finish_transaction_with_five_fourty() {
        VendingMachine testVendingMachine = new VendingMachine(new BigDecimal("5.40"));
        BigDecimal testResult = testVendingMachine.finishTransaction();
        Assert.assertEquals(new BigDecimal("0.00"), testResult);
    }

    @Test
    public void test_finish_transaction_with_zero() {
        VendingMachine testVendingMachine = new VendingMachine(new BigDecimal("0.00"));
        BigDecimal testResult = testVendingMachine.finishTransaction();
        Assert.assertEquals(new BigDecimal("0.00"), testResult);
    }

    @Test
    public void test_finish_transaction_with_large_number() {
        VendingMachine testVendingMachine = new VendingMachine(new BigDecimal("50824.55"));
        BigDecimal testResult = testVendingMachine.finishTransaction();
        Assert.assertEquals(new BigDecimal("0.00"), testResult);
    }

}
