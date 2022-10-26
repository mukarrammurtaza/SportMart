package com.example.sportmart;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductActivity extends MainActivity {

    public  static List<String> cartList = new ArrayList<>();
    Context context;

    int itemQuantity = 0;
    private NumberPicker qPicker;
    ICartDAO dao;
    Logger logger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        context = getApplicationContext();
        TextView name = findViewById(R.id.name);
        TextView price = findViewById(R.id.price);

        ImageView image = findViewById(R.id.imageview);


        Intent intent = getIntent();
        String recName = intent.getStringExtra("name");
        name.setText(recName);
        String recPrice = intent.getStringExtra("price");
        price.setText(recPrice);

        Bundle bundle = getIntent().getExtras();
        int resid = bundle.getInt("image");
        image.setImageResource(resid);
        dao= new CartDbDAO(this);
        logger=Logger.getLogger("Product Activity");
        qPicker = findViewById(R.id.numpicker);
        qPicker.setMaxValue(10);
        qPicker.setMinValue(1);
        String values[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        qPicker.setDisplayedValues(values);
        qPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                int valuePicker = qPicker.getValue();
                Log.d("picker value", valuePicker + "");
            }
        });


        Button launchCart = (Button) findViewById(R.id.CartLauncherButton);

        launchCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CartActivity.class);

                startActivity(intent);
            }
        });
        Button addToCart = (Button) findViewById(R.id.addToCartButton);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int newRecPrice = Integer.parseInt(recPrice);


                product obj = new product(recName, newRecPrice, resid, qPicker.getValue());


                boolean check = cartList.contains(recName);
                itemQuantity = qPicker.getValue();
                if (check == false) {
                    cartList.add(recName);
//                    // obj.setQuantity(++itemQuantity);
                    //cart.addToCart(obj);
                    dao.save(obj);
                    logger.log(Level.INFO, "saved   object in cart");
                    Toast.makeText(getApplicationContext(), "ADDED TO CART", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getApplicationContext(), "ITEM ALREADY IN CART", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }


}
