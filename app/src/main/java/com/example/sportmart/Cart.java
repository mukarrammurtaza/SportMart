package com.example.sportmart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private static Cart c = new Cart();

    List<product>  cart = new ArrayList<>();

    private Cart(){}

    public void addToCart(product obj){

        if(cart != null)
            cart.add(obj);
        else if (cart == null)
            cart = new ArrayList<>();
    }

    public static Cart getInstance() {
        return c;
    }

    public List<product> getItems(){
        return cart;
    }

    public void emptyCart(){
        cart= new ArrayList<>();
    }
}
