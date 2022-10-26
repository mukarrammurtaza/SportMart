package com.example.sportmart;

public class product {

    String id;
    String name;
    int price;
    int image;
    int rating;
    int quantity;

    public product() {
        this.id = null;
        this.name = null;
        this.price = 0;
        this.image = 0;

        this.quantity=0;
    }

    public product(String name, int price, int image, int quantity) {
        this.id = null;
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
}


