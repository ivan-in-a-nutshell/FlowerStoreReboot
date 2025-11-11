package com.example.demo.delivery;

import com.example.demo.item.Item;

import java.util.List;

public interface Delivery {
    String deliver(List<Item> items);
}
