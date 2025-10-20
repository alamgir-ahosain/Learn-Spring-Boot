package com.alamgir.i_consuming_rest_api.dto;

import java.util.List;
public class ProductDto {
    /*
      [
  {
    "id": 4,
    "title": "Handmade Fresh Table",
    "slug": "handmade-fresh-table",
    "price": 687,
    "description": "Andy shoes are designed to keeping in...",
    "category": {
        "id": 5,
        "name": "Others",
        "image": "https://placehold.co/600x400",
        "slug": "others"
    },
    "images": [
        "https://placehold.co/600x400",
        "https://placehold.co/600x400",
        "https://placehold.co/600x400"
    ]
  }
   ...
]
     */

    private int id;
    private String title;
    private String slug;
    private double price;
    private String description;
    private Category category;
    private List<String>  image;
    public int getId() {  return id;}
    public void setId(int id) {   this.id = id; }
    public String getTitle() {   return title;   }
    public void setTitle(String title) {      this.title = title;}
    public String getSlug() {   return slug;}
    public void setSlug(String slug) {   this.slug = slug; }
    public double getPrice() {    return price;}
    public void setPrice(double price) {   this.price = price;}
    public String getDescription() {  return description; }
    public void setDescription(String description) {   this.description = description; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) {  this.category = category; }
    public List<String> getImage() {return image;}
    public void setImage(List<String> image) {  this.image = image;}
}
