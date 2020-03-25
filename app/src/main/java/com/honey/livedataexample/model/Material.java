package com.honey.livedataexample.model;

import com.google.gson.annotations.SerializedName;

public class Material {
    @SerializedName("mname")
    private String mname;

    @SerializedName("type")
    private int type;

    @SerializedName("amount")
    private String amount;

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
