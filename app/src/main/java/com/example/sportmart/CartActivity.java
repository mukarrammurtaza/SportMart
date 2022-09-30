package com.example.sportmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    List<product> productList;
    //private String CHANNEL_ID;
    int totalBill =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        final Cart cart = Cart.getInstance();
           // Intent intent = getIntent();
           // intent.getExtra("cart")
        productList = cart.getItems();

        int n;
        for (int i=0; i< productList.size(); i++){

            String p = String.valueOf( productList.get(i).getPrice());
            n = Integer.parseInt(p);

            totalBill = totalBill + n*productList.get(i).quantity;
        }
        TextView tv = (TextView) findViewById(R.id.totalbill);
        String bill = "Total Bill: "+ totalBill;
        tv.setText(bill);
        RecyclerView rv = (RecyclerView) findViewById(R.id.Cartrecyclerview);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CartAdapter( this,productList));

      //  productList.add(new product("American Football", 400, R.drawable.americanfootball, 3));

//        Button btn = findViewById(R.id.placeorder);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(cart.getItems().size()==0)
//                    Toast.makeText(getApplicationContext(), "Fill your cart first to place order", Toast.LENGTH_SHORT).show();
//                else {
//                    cart.emptyCart();
//                    Intent intent = new Intent(v.getContext(), order_placed.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }
//        });


    }

}
