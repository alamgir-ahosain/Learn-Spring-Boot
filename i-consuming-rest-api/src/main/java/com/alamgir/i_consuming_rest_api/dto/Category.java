package com.alamgir.i_consuming_rest_api.dto;

public class Category {

    private int id;
    private String name;
    private String image;
    private String slug;

    public int getId() {return id; }
    public void setId(int id) {  this.id = id;  }
    public String getName() {     return name;    }
    public void setName(String name) {    this.name = name;  }
    public String getImage() {     return image;  }
    public void setImage(String image) {     this.image = image;   }
    public String getSlug() {     return slug;  }
    public void setSlug(String slug) {     this.slug = slug;  }
}

/*
 "category": {
        "id": 5,
        "name": "Others",
        "image": "https://placehold.co/600x400",
        "slug": "others"
    },
 */