package com.alamgir.h_rest_service.request.order;

import java.util.List;

public class Order {
    private String name;
    private String email;
    private String mobile;
    private double totalAmount;
    private List<Product> products;
    private Delivery delivery;
    private Payment payment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order [name=" + name + ", email=" + email + ", mobile=" + mobile + ", totalAmount=" + totalAmount
                + ", products=" + products + ", delivery=" + delivery + ", payment=" + payment + "]";
    }


}
