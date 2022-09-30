package com.example.sportmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context=getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<product> productList =new ArrayList<>();
        Button launchCart=(Button)findViewById(R.id.CartLauncherButton);
        launchCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,CartActivity.class);

                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(this, productList));
       // recyclerView.addOnItemTouchListener;
        productList.add(new product("American Football", 400, R.drawable.americanfootball, 10));
        productList.add(new product("Football", 1000, R.drawable.football, 10));
        productList.add(new product("Basketball", 2000, R.drawable.basketball, 10));
        productList.add(new product("Shuttle Cock", 100, R.drawable.shuttlecock, 10));
        productList.add(new product("Olympic Barbell", 4000, R.drawable.barbell, 10));
        productList.add(new product("Boxing Gloves", 3000, R.drawable.boxinggloves, 10));
        productList.add(new product("Skipping Rope", 500, R.drawable.skippingrope, 10));
        productList.add(new product(" Badminton Racket", 1000, R.drawable.racket, 10));
        productList.add(new product("Cricket Helmet", 4000, R.drawable.crickethelmet, 10));
        productList.add(new product("Dumbbells 5 KG", 3000, R.drawable.dumbbells, 10));
        productList.add(new product(" TreadMill", 500000, R.drawable.treadmill, 10));
        productList.add(new product(" Table Tennis Racket", 1000, R.drawable.tabletennis, 10));
        productList.add(new product("SkateBoard", 10000, R.drawable.skateboard, 10));
        productList.add(new product("BaseBall Bat", 15000, R.drawable.baseballbat, 10));



    }


}
