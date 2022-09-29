package com.example.sportmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
List<product> cartList;
int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        TextView name = (TextView)findViewById(R.id.name);
        TextView price = (TextView)findViewById(R.id.price);
        TextView rating = (TextView)findViewById(R.id.rating);
        TextView quantityView = (TextView)findViewById(R.id.quantity);
        ImageView image = (ImageView) findViewById(R.id.imageview);
        TextView totalPrice=(TextView) findViewById(R.id.totalAmount);
        ImageButton add=(ImageButton)findViewById(R.id.addButton);
        ImageButton remove=(ImageButton)findViewById(R.id.removeButton);
        Intent intent=getIntent();
        String recName=intent.getStringExtra("name");
        name.setText(recName);
        String recPrice=intent.getStringExtra("price");
        price.setText(recPrice);
        Bundle bundle=getIntent().getExtras();
        int resid=bundle.getInt("image");
        image.setImageResource(resid);


        /*RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CartAdapter(this, cartList));*/
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantity=quantity+1;
                if(v.getId()==R.id.addButton){
                if(cartList==null){

                    //
                }
                quantityView.setText(""+quantity);

            }}
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity--;
                if(v.getId()==R.id.removeButton) {

                    quantityView.setText(""+quantity);
                }
            }
        });

    }
public void calculateAmount(){



}
}