package org.example.domain;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private double price;
    private double rating;

    private static final double DEFAULT_RATING = 0d;

    public Product(String name, double price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.rating = DEFAULT_RATING;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
