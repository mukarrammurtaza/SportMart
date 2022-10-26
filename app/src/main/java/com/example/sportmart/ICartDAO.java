package com.example.sportmart;

import java.util.ArrayList;
import java.util.List;

public interface ICartDAO {
    void save(product product);

    void save(ArrayList<product> products);

    ArrayList<product> load();

    product load(String id);

    void resetCart();

}
