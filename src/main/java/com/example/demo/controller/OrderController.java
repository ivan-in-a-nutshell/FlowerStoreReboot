package com.example.demo.controller;

import com.example.demo.decorator.PaperDecorator;
import com.example.demo.decorator.RibbonDecorator;
import com.example.demo.delivery.DHLDeliveryStrategy;
import com.example.demo.delivery.PostDeliveryStrategy;
import com.example.demo.item.Flower;
import com.example.demo.item.Item;
import com.example.demo.order.Order;
import com.example.demo.payment.CreditCardPaymentStrategy;
import com.example.demo.payment.PayPalPaymentStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @GetMapping("/demo-paypal-dhl")
    public String demoOrderPaypal() {
        Item rose = new Flower(10.5, 50.0, "Red", "Rose");
        Item decoratedRose = new PaperDecorator(rose);
        Item decoratedRoseWithRibbon = new RibbonDecorator(decoratedRose);

        Order order = new Order();
        order.addItem(decoratedRoseWithRibbon);

        order.setPaymentStrategy(new PayPalPaymentStrategy());
        order.setDeliveryStrategy(new DHLDeliveryStrategy());

        return order.processOrder();
    }

    @GetMapping("/demo-creditcard-post")
    public String demoOrderCreditCard() {
        Item lily = new Flower(7.2, 35.0, "White", "Lily");
        Item decoratedLily = new PaperDecorator(lily);

        Order order = new Order();
        order.addItem(decoratedLily);

        order.setPaymentStrategy(new CreditCardPaymentStrategy());
        order.setDeliveryStrategy(new PostDeliveryStrategy());

        return order.processOrder();
    }
}
