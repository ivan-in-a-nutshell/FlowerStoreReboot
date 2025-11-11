package com.example.demo.decorator;

import com.example.demo.item.Item;

public abstract class ItemDecorator extends Item {
    protected Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public abstract String getDescription();
}
