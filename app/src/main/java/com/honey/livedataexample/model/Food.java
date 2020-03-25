package com.honey.livedataexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Food {
    @SerializedName("id")
    private int id;

    @SerializedName("classid")
    private int classid;

    @SerializedName("name")
    private String name;

    @SerializedName("peoplenum")
    private String peoplenum;

    @SerializedName("preparetime")
    private String preparetime;

    @SerializedName("cookingtime")
    private String cookingtime;

    @SerializedName("content")
    private String content;

    @SerializedName("pic")
    private String pic;

    @SerializedName("tag")
    private String tag;

    @SerializedName("material")
    private List<Material> materials;

    @SerializedName("process")
    private List<FoodProcess> process;


    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(String peoplenum) {
        this.peoplenum = peoplenum;
    }

    public String getPreparetime() {
        return preparetime;
    }

    public void setPreparetime(String preparetime) {
        this.preparetime = preparetime;
    }

    public String getCookingtime() {
        return cookingtime;
    }

    public void setCookingtime(String cookingtime) {
        this.cookingtime = cookingtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<FoodProcess> getProcess() {
        return process;
    }

    public void setProcess(List<FoodProcess> process) {
        this.process = process;
    }
}
