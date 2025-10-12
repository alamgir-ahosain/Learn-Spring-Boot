package com.alamgir.h_rest_service.request.order;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private List<String> specification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getSpecification() {
        return specification;
    }

    public void setSpecification(List<String> specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
                + ", specification=" + specification + "]";
    }

    
}
