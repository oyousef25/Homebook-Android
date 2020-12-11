package com.example.homebook.recyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homebook.R;
import com.example.homebook.pojo.HouseItem;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder> {
    private ArrayList<HouseItem> houseItems;

    public CustomRecyclerViewAdapter(ArrayList<HouseItem> houseItems) {
        this.houseItems = houseItems;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_houses_list_recyclerview, null);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        HouseItem item = houseItems.get(position);
        holder.image.setImageResource(item.getImage());
        holder.price.setText(item.getPrice());
        holder.details.setText(item.getDetails());
        holder.address.setText(item.getAddress());
    }

    @Override
    public int getItemCount() {
        if (houseItems != null){
            return houseItems.size();
        }else{
            return 0;
        }
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected ImageView image;
        protected TextView price;
        protected TextView details;
        protected TextView address;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
//            this.name = itemView.findViewById(R.id.recipeName);
            this.image = itemView.findViewById(R.id.houseImage);
            this.price = itemView.findViewById(R.id.housePrice);
            this.details = itemView.findViewById(R.id.houseDetails);
            this.address = itemView.findViewById(R.id.houseAddress);
        }
    }
}
