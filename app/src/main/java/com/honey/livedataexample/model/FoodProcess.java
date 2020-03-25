package com.honey.livedataexample.model;

import com.google.gson.annotations.SerializedName;

public class FoodProcess {

    @SerializedName("pcontent")
    private String pcontent;

    @SerializedName("pic")
    private String pic;

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
