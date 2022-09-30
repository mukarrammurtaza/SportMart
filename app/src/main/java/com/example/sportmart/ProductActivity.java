package com.example.sportmart;



import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends MainActivity{

    Context context;
    Cart cart = Cart.getInstance();
    public static List<String> cartList=new ArrayList<>();
    int itemQuantity=0;
    private NumberPicker qPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        context=getApplicationContext();
      TextView name = findViewById(R.id.name);
        TextView price = findViewById(R.id.price);
        TextView rating = findViewById(R.id.rating);
        ImageView image=findViewById(R.id.imageview);
       // EditText quantityVIew = findViewById(R.id.quantityView);
       // quantityVIew.setText("0");
        Intent intent=getIntent();
        String recName=intent.getStringExtra("name");
        name.setText(recName);
        String recPrice=intent.getStringExtra("price");
        price.setText(recPrice);
       // int newRecPrice=Integer.parseInt(recPrice);
        String recRating=intent.getStringExtra("rating");
        rating.setText(recRating);
        Bundle bundle=getIntent().getExtras();
        int resid=bundle.getInt("image");
        image.setImageResource(resid);

        qPicker=findViewById(R.id.numpicker);
        qPicker.setMaxValue(10);
        qPicker.setMinValue(1);
        String values[]={"1","2","3","4","5","6","7","8","9","10"};
        qPicker.setDisplayedValues(values);
        qPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                int valuePicker = qPicker.getValue();
                Log.d("picker value", valuePicker + "");
            }
        });

//        Button AddButton=findViewById(R.id.Addbutton);
//        AddButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(v.getId()==R.id.Addbutton) {
//                    itemQuantity = itemQuantity + 1;
//                    quantityVIew.setText(itemQuantity);
//                }
//
//            }
//        });
//        Button RemoveButton=findViewById(R.id.Removebutton);
//        AddButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(v.getId()==R.id.Removebutton) {
//                if(itemQuantity!=0) {
//                    itemQuantity--;
//                    quantityVIew.setText(itemQuantity);
//                }
//                }
//            }
//        });
        Button launchCart=(Button)findViewById(R.id.CartLauncherButton);

        launchCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,CartActivity.class);

                startActivity(intent);
            }
        });
        Button addToCart=(Button)findViewById(R.id.addToCartButton);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String recName=intent.getStringExtra("name");
              //  name.setText(recName);
               // String recPrice=intent.getStringExtra("price");
              //  price.setText(recPrice);
                int newRecPrice=Integer.parseInt(recPrice);
              //  String recRating=intent.getStringExtra("rating");
              //  rating.setText(recRating);
                int newRecRating=Integer.parseInt(recRating);
                //Bundle bundle=getIntent().getExtras();
                //int resid=bundle.getInt("image");
               // image.setImageResource(resid);

               // itemQuantity=0;

                product obj = new product(recName,newRecPrice,resid, qPicker.getValue());


                boolean check= cartList.contains(recName);
                    itemQuantity=qPicker.getValue();
                if(check==false) {
                    cartList.add(recName);
                    obj.setQuantity(qPicker.getValue());
                   // obj.setQuantity(++itemQuantity);
                    cart.addToCart(obj);

                    Toast.makeText(getApplicationContext(), "ADDED TO CART", Toast.LENGTH_SHORT).show();
               }
                else {
                   // obj.setQuantity(++itemQuantity);
                    //updated in list?
                    //2 instances of same item if back button pressed
                    Toast.makeText(getApplicationContext(), "ITEM ALREADY IN CART", Toast.LENGTH_SHORT).show();

                }
            //  Intent intent=new Intent(context,CartActivity.class);
             //  intent.putExtra("name",name.getText().toString());
             //   intent.putExtra("price",price.getText().toString());
             //   intent.putExtra("rating",rating.getText().toString());
          //    intent.putExtra("image",resid);


               //intent.putExtra("cart", (Parcelable) cart);

               //startActivity(intent);
            }
        });

    }
    //public void launchCart(View v){
    //    Intent intent=new Intent(context,CartActivity.class);
    //    intent.putExtra("name",
     //           context.startActivity(intent);
  //  }


}
