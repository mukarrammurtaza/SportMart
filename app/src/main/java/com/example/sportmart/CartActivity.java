package com.example.sportmart;

import static com.example.sportmart.ProductActivity.cartList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartActivity extends AppCompatActivity {
    CartAdapter adp;
    ArrayList<product> productList;
    int totalBill = 0;
    ICartDAO dao=new CartDbDAO(this);
    Logger logger;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);


        logger=Logger.getLogger("CART ACTIVITY");

        productList=dao.load();
        int n;
        for (int i = 0; i < productList.size(); i++) {

            String p = String.valueOf(productList.get(i).getPrice());
            n = Integer.parseInt(p);


            totalBill = totalBill + n * productList.get(i).quantity;
        }
       tv = (TextView) findViewById(R.id.totalbill);
        String bill = "Total Bill: " + totalBill;
        tv.setText(bill);

        RecyclerView rv = (RecyclerView) findViewById(R.id.Cartrecyclerview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adp = new CartAdapter(this, productList);
        rv.setAdapter(adp);


    }

    public void resetCart(View v){

      adp.filterList();
        dao.resetCart();



    }

}
