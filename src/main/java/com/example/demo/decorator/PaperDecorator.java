package com.example.demo.decorator;

import com.example.demo.item.Item;

public class PaperDecorator extends ItemDecorator {
    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " wrapped in paper.";
    }

    @Override
    public double price() {
        return 13 + item.price();
    }
}
