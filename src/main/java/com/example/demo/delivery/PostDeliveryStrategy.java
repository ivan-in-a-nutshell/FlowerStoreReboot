package com.example.demo.delivery;

import com.example.demo.item.Item;

import java.util.List;

public class PostDeliveryStrategy implements Delivery{
    @Override
    public String deliver(List<Item> items) {
        return "Delivering " + items.size() + " items by Post.";
    }
}
