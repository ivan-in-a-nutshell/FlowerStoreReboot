package com.example.demo;

import com.example.demo.decorator.BasketDecorator;
import com.example.demo.decorator.PaperDecorator;
import com.example.demo.item.Flower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecoratorTests {

    @Test
    public void decorateRoseWithPaperTest() {
        Flower rose = new Flower(100, 10, "Red", "Rose");
        PaperDecorator paperDecorator = new PaperDecorator(rose);

        Assertions.assertEquals("Rose wrapped in paper.", paperDecorator.getDescription());
        Assertions.assertEquals(100, rose.getPrice());
    }

    @Test
    public void decorateFlowerInBasketTest() {
        Flower some_flower = new Flower(100, 10, "Red", "Some flower");
        BasketDecorator basketDecorator = new BasketDecorator(some_flower);

        Assertions.assertEquals("Some flower in a basket.", basketDecorator.getDescription());
        Assertions.assertEquals(100, some_flower.getPrice());
    }
}
