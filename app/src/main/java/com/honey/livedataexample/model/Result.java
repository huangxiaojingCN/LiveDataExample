package com.honey.livedataexample.model;

import com.google.gson.annotations.SerializedName;

public class Result {

    /**
     *  "status": 0,
     *     "msg": "ok",
     *     "result": {
     */

    @SerializedName("status")
    private int status;

    @SerializedName("msg")
    private String msg;

    @SerializedName("result")
    private FoodList foodList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public FoodList getFoodList() {
        return foodList;
    }

    public void setFoodList(FoodList foodList) {
        this.foodList = foodList;
    }
}
