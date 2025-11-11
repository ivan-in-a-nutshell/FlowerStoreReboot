package com.example.demo.decorator;

import com.example.demo.item.Item;

public class RibbonDecorator extends ItemDecorator{
    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " with a ribbon.";
    }

    @Override
    public double price() {
        return 40 + item.price();
    }
}
