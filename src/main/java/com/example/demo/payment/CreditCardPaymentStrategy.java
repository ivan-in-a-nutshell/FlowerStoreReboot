package com.example.demo.payment;

public class CreditCardPaymentStrategy implements Payment{
    @Override
    public String pay(double price) {
        return "Paid $" + price + " with Credit Card.";
    }
}
