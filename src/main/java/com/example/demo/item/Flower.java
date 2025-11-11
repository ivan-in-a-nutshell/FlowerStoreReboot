package com.example.demo.item;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flowers")
@Data
@NoArgsConstructor
public class Flower extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flowerId;
    private double price;
    private double sepalLength;
    private String color;
    private String description;

    public Flower(double price, double sepalLength, String color, String description) {
        this.price = price;
        this.sepalLength = sepalLength;
        this.color = color;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double price() {
        return price;
    }
}
