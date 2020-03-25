package com.honey.livedataexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.honey.livedataexample.model.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    List<Food> foodList;

    public void addDatas(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_food, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.mTvTitle.setText(food.getName());

        Glide.with(holder.itemView.getContext())
                .load(food.getPic())
                .into(holder.mIvPic);
    }

    @Override
    public int getItemCount() {
        return foodList == null ? 0 : foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvTitle;

        private ImageView mIvPic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mTvTitle = itemView.findViewById(R.id.tv_title);
            mIvPic = itemView.findViewById(R.id.iv_pic);
        }
    }
}
