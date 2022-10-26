package com.example.sportmart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.cViewHolder> {
    private Context context;
    ArrayList<product> productList;

    public CartAdapter(Context context, ArrayList<product> productList) {
        this.context = context;
        this.productList = productList;

    }
    public void filterList() {
        // below line is to add our filtered
        // list in our course array list.
        productList = new ArrayList<>();
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public cViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cart, parent, false);

        return new cViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cViewHolder holder, int position) {

        holder.getNameView().setText(productList.get(position).getName());
        holder.getPriceView().setText(String.valueOf(productList.get(position).getPrice()));
//        holder.getRatingView().setText(String.valueOf(productList.get(position).getRating()));
        holder.getImageView().setImageResource((productList.get(position).getImage()));
        holder.getQuantityView().setText(String.valueOf(productList.get(position).getQuantity()));


    }



    @Override
    public int getItemCount() {
        return productList.size();
    }


    public static class cViewHolder extends RecyclerView.ViewHolder {
        private final View itemView;
        private final TextView nameView;
        private final TextView ratingView;
        private final TextView priceView;
        private final  TextView QuantityView;
        private final ImageView ImageView;



        public cViewHolder(View view) {
            super(view);
            itemView = view;
            nameView = (TextView) view.findViewById(R.id.name);
            ratingView = (TextView) view.findViewById(R.id.rating);
            priceView = (TextView) view.findViewById(R.id.price);
            QuantityView = (TextView) view.findViewById(R.id.quantity);
            ImageView = (ImageView) view.findViewById(R.id.imageview);


        }

        public View getItemView() {
            return nameView;
        }

        public TextView getNameView() {
            return nameView;
        }

        public TextView getPriceView() {
            return priceView;
        }

        public TextView getRatingView() {
            return ratingView;
        }


        public ImageView getImageView() {
            return ImageView;
        }

         public TextView getQuantityView() {return QuantityView;}


    }

}


