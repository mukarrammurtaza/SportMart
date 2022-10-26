package com.example.sportmart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<product> productList;
    private Context context;

    public MyAdapter(Context context, List<product> productList) {
        this.context = context;
        this.productList = productList;

    }

    public void filterList(List<product> filterlist) {

        productList = filterlist;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getNameView().setText(productList.get(position).getName());
        holder.getPriceView().setText(String.valueOf(productList.get(position).getPrice()));
        holder.getImageView().setImageResource((productList.get(position).getImage()));
        holder.getItemView().setOnClickListener(new View.OnClickListener() {

                                                    @Override
                                                    public void onClick(View v) {

                                                        Intent intent = new Intent(context, ProductActivity.class);
                                                        // intent.putExtra()
                                                        intent.putExtra("name", holder.getNameView().getText().toString());
                                                        intent.putExtra("price", holder.priceView.getText().toString());
                                                        //intent.putExtra("rating", holder.ratingView.getText().toString());
                                                        intent.putExtra("image", (productList.get(position).getImage()));

                                                        //quantity
                                                        context.startActivity(intent);
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
      //  private final TextView ratingView;
        private final TextView priceView;
        private final TextView QuantityView;
        private final ImageView ImageView;

        public ViewHolder(View view) {
            super(view);
            itemView = view;
            nameView = view.findViewById(R.id.name);

            priceView =  view.findViewById(R.id.price);
            QuantityView =  view.findViewById(R.id.quantity);
            ImageView =  view.findViewById(R.id.imageview);

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




        public ImageView getImageView() {
            return ImageView;
        }

        public TextView getQuantityView() {
            return QuantityView;
        }
    }
}


