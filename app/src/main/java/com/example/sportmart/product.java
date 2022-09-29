package com.example.sportmart;

public class product
{

        String name;
        int price;
        int image;
        int rating;
        int quantity;
        public product(String name, int price, int image, int rating) //int quantity)
        {
            this.name = name;
            this.price = price;
            this.image = image;
            this.rating = rating;
            this.quantity=quantity;
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

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {this.quantity = quantity;}

}


