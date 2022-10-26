package com.example.sportmart;



import static com.example.sportmart.CartContract.CartEntry.COLUMN_NAME_ID;
import static com.example.sportmart.CartContract.CartEntry.COLUMN_NAME_IMAGE;
import static com.example.sportmart.CartContract.CartEntry.COLUMN_NAME_NAME;
import static com.example.sportmart.CartContract.CartEntry.COLUMN_NAME_PRICE;
import static com.example.sportmart.CartContract.CartEntry.COLUMN_NAME_QUANTITY;
import static com.example.sportmart.CartContract.CartEntry.TABLE_NAME;
import static com.example.sportmart.ProductActivity.cartList;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartDbDAO implements ICartDAO{

    private Context context;
    Logger logger;

    CartDbDAO(Context ctx){context=ctx;
    }
    @Override
    public void save(product product) {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(COLUMN_NAME_NAME, product.getName());
        content.put(COLUMN_NAME_PRICE, product.getPrice());
        content.put(COLUMN_NAME_IMAGE, product.getImage());
        content.put(COLUMN_NAME_QUANTITY, product.getQuantity());



        if (product.getId() != null) {
            String[] arguments = new String[1];
            arguments[0] = product.getId();
            db.update(TABLE_NAME, content, "id = ?", arguments);
        } else {
            product.setId(UUID.randomUUID().toString());
           content.put(COLUMN_NAME_ID, product.getId());
            db.insert(TABLE_NAME, null, content);
        }
    }

    @Override
    public void save(ArrayList<product> products) {
        for (product p : products) {
            save(p);
        }
    }

    @SuppressLint("Range")
    @Override
    public ArrayList<product> load() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<product> products = new ArrayList<>();
        while (cursor.moveToNext()) {
            String[] columns = cursor.getColumnNames();
            product p = new product();
            for (String col : columns) {
                if (col.equalsIgnoreCase(COLUMN_NAME_ID))
                    p.setId(cursor.getString(cursor.getColumnIndex(col)));
                else if (col.equalsIgnoreCase(COLUMN_NAME_NAME))
                    p.setName(cursor.getString(cursor.getColumnIndex(col)));
                else if (col.equalsIgnoreCase(COLUMN_NAME_PRICE))
                    p.setPrice(cursor.getInt(cursor.getColumnIndex(col)));
                else if (col.equalsIgnoreCase(COLUMN_NAME_IMAGE))
                    p.setImage(cursor.getInt(cursor.getColumnIndex(col)));
                else if (col.equalsIgnoreCase(COLUMN_NAME_QUANTITY))
                    p.setQuantity(cursor.getInt(cursor.getColumnIndex(col)));

            }
            products.add(p);
        }
        cursor.close();
        return products;
    }

    @SuppressLint("Range")
    @Override
    public product load(String id) {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        String[] arguments = new String[1];
        arguments[0] = id;
        Cursor cursor = db.rawQuery(query, arguments);


        product product = new product();

        while (cursor.moveToNext()) {
            String[] columns = cursor.getColumnNames();
            for (String col : columns) {
                if (col.equalsIgnoreCase(COLUMN_NAME_ID))
                    product.setId(cursor.getString(cursor.getColumnIndex(col)));
                else if (col.equalsIgnoreCase(COLUMN_NAME_NAME))
                    product.setName(cursor.getString(cursor.getColumnIndex(col)));
                else if (col.equalsIgnoreCase(COLUMN_NAME_PRICE))
                    product.setPrice(cursor.getInt(cursor.getColumnIndex(col)));
                else if (col.equalsIgnoreCase(COLUMN_NAME_IMAGE))
                    product.setImage(cursor.getInt(cursor.getColumnIndex(col)));

            }
        }
        cursor.close();
        return product;
    }

    @Override
    public void resetCart() {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        cartList.clear();


    }

}

