/*
package com.example.sportmart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private Context context;
    List<product> productList;

    public CartAdapter(Activity context, List<product> productList) {
        this.context = context;
        this.productList = productList;
        Intent intent=context.getIntent();

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cart, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.getNameView().setText(productList.get(position).getName());
        holder.getPriceView().setText(String.valueOf(productList.get(position).getPrice()));
        holder.getRatingView().setText(String.valueOf(productList.get(position).getRating()));
        holder.getImageView().setImageResource((productList.get(position).getImage()));
        //holder.getQuantityView().setText(String.valueOf(productList.get(position).getQuantity()));
        holder.getItemView().setOnClickListener(new View.OnClickListener() {

                                                    @Override
                                                    public void onClick(View v) {

                                                       // Intent intent = new Intent(context, ProductActivity.class);
                                                        // intent.putExtra()
                                                        //intent.putExtra("name", holder.getNameView().getText().toString());
                                                        //intent.putExtra("price", holder.priceView.getText().toString());
                                                        //intent.putExtra("rating", holder.ratingView.getText().toString());
                                                        //intent.putExtra("image",(productList.get(position).getImage()));
                                                        //quantity
                                                       // context.startActivity(intent);
                                                    }

                                                }

        );

    }



    @Override
    public int getItemCount() {
        return productList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final View itemView;
        private final TextView nameView;
        private final TextView ratingView;
        private final TextView priceView;
        private final  TextView QuantityView;
        private final ImageView ImageView;

         ViewHolder(View view) {
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


*/
