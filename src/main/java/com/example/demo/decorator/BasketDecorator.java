package com.example.demo.decorator;

import com.example.demo.item.Item;

public class BasketDecorator extends ItemDecorator{
    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " in a basket.";
    }

    @Override
    public double price() {
        return 4 + item.price();
    }
}
