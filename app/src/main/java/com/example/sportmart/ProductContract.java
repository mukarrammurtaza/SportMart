package com.example.sportmart;

import android.provider.BaseColumns;

public final class ProductContract {
    private ProductContract() {
    }

    public static class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "product";
        public static final String COLUMN_NAME_ID = _ID;
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_IMAGE = "image";
        public static final String COLUMN_NAME_RATING = "rating";
    }



}
