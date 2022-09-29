package com.example.sportmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<product> productList =new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(this, productList));
       // recyclerView.addOnItemTouchListener;
        productList.add(new product("American Football", 400, R.drawable.americanfootball, 3));
        productList.add(new product("Football", 1000, R.drawable.football, 4));
        productList.add(new product("Basketball", 2000, R.drawable.basketball, 5));
        productList.add(new product("Shuttle Cock", 100, R.drawable.shuttlecock, 2));
        productList.add(new product("Olympic Barbell", 4000, R.drawable.barbell, 5));
        productList.add(new product("Boxing Gloves", 3000, R.drawable.boxinggloves, 4));
        productList.add(new product("Skipping Rope", 500, R.drawable.skippingrope, 3));
        productList.add(new product(" Badminton Racket", 1000, R.drawable.racket, 2));
        productList.add(new product("Cricket Helmet", 4000, R.drawable.crickethelmet, 1));
        productList.add(new product("Dumbbells 5 KG", 3000, R.drawable.dumbbells, 4));
        productList.add(new product(" TreadMill", 500000, R.drawable.treadmill, 3));
        productList.add(new product(" Table Tennis Racket", 1000, R.drawable.tabletennis, 2));
        productList.add(new product("SkateBoard", 10000, R.drawable.skateboard, 5));
        productList.add(new product("BaseBall Bat", 15000, R.drawable.baseballbat, 4));



    }


}
