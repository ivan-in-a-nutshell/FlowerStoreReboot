package com.example.demo.order;

import com.example.demo.delivery.Delivery;
import com.example.demo.item.Item;
import com.example.demo.payment.Payment;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
public class Order {
    private List<Item> items = new LinkedList<>();
    private Payment payment;
    private Delivery delivery;

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }

    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::price).sum();
    }

    public String processOrder() {
        String paymentStatus = payment.pay(calculateTotalPrice());
        String deliveryStatus = delivery.deliver(items);
        return "Order Processed:\n" + paymentStatus + "\n" + deliveryStatus;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
