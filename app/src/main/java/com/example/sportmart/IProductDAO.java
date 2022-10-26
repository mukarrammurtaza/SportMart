package com.example.sportmart;

import java.util.ArrayList;

public interface IProductDAO {
    void save(product product);

    void save(ArrayList<product> products);

    ArrayList<product> load();

    product load(String id);
}
