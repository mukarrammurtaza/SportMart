package com.example.sportmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends  AppCompatActivity{
    Context context;
 MyAdapter adp;
    List<product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productList = new ArrayList<>();
        Button launchCart = (Button) findViewById(R.id.CartLauncherButton);
        launchCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CartActivity.class);

                startActivity(intent);
            }
        });


        // recyclerView.setAdapter(new MyAdapter(this, productList));

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

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adp=new MyAdapter(this, productList);
        recyclerView.setAdapter(adp);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        List<product> filteredlist = new ArrayList<product>();


        for (product item : productList) {

            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
            }
                else {

                    adp.filterList(filteredlist);
        }
    }

}

