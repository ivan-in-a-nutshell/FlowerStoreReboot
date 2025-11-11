package com.example.demo.item;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket extends Item {
    private final List<Flower> flowers = new ArrayList<>();

    private void addFlower(Flower flower) {
        flowers.add(flower);
    }

    @Override
    public double price() {
        return flowers.stream().mapToDouble(flower -> flower.getPrice()).sum();
    }

    @Override
    public String getDescription() {
        return "A bucket with " +  flowers.size() + " flowers";
    }
}
