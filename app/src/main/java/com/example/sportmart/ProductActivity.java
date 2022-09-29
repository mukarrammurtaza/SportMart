package com.example.sportmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class ProductActivity extends MainActivity{

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        context=getApplicationContext();
      TextView name = (TextView)findViewById(R.id.name);
        TextView price = (TextView)findViewById(R.id.price);
        TextView rating = (TextView)findViewById(R.id.rating);
        ImageView image=(ImageView)findViewById(R.id.imageview);
        Intent intent=getIntent();
        String recName=intent.getStringExtra("name");
        name.setText(recName);
        String recPrice=intent.getStringExtra("price");
        price.setText(recPrice);
        String recRating=intent.getStringExtra("rating");
        rating.setText(recRating);
       Bundle bundle=getIntent().getExtras();
       int resid=bundle.getInt("image");
      image.setImageResource(resid);
        Button launchCart=(Button)findViewById(R.id.buyButton);
        launchCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,CartActivity.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("price",price.getText().toString());
                intent.putExtra("rating",rating.getText().toString());
               intent.putExtra("image",resid);




                startActivity(intent);
            }
        });

    }
    //public void launchCart(View v){
    //    Intent intent=new Intent(context,CartActivity.class);
    //    intent.putExtra("name",
     //           context.startActivity(intent);
  //  }

}