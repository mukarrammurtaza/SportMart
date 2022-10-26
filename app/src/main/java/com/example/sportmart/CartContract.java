package com.example.sportmart;

import android.provider.BaseColumns;

public class CartContract {
    private CartContract(){

    }
    public static class CartEntry implements BaseColumns {
        public static final String TABLE_NAME = "cart";
        public static final String COLUMN_NAME_ID = _ID;
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_IMAGE = "image";
        public static final String COLUMN_NAME_QUANTITY = "quantity";


    }
}
