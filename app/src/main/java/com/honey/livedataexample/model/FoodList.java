package com.honey.livedataexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodList {

    @SerializedName("list")
    private List<Food> foodList;

    @SerializedName("total")
    private int total;

    @SerializedName("num")
    private int num;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
