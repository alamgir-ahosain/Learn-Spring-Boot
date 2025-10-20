package com.alamgir.i_consuming_rest_api.dto.another;

public class ProductDto2 {

    private int id;
    private String title;
    private double price;
     private String description;
    private String category;
    private String image;

    
    public int getId() { return id;  }
    public void setId(int id) {     this.id = id;  }
    public String getTitle() {    return title;   }
    public void setTitle(String title) {     this.title = title; }
    public double getPrice() {    return price;}
    public void setPrice(double price) {    this.price = price;}
    public String getDescription() {     return description; }
    public void setDescription(String description) {    this.description = description;  }
    public String getCategory() { return category; }
    public void setCategory(String category) {this.category = category;    }
    public String getImage() {    return image;  }
    public void setImage(String image) {  this.image = image;    }
    
}

/*
 [
  {
    "id": 0,
    "title": "string",
    "price": 0.1,
    "description": "string",
    "category": "string",
    "image": "http://example.com"
  }
]
 */