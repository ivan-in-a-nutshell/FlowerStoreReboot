package com.example.demo.payment;

public class PayPalPaymentStrategy implements Payment{
    @Override
    public String pay(double price) {
        return "Paid $" + price + " with PayPal.";
    }
}
