package com.example.krok_kursova.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Auto {
    @SerializedName("imgUrl")
    @Expose
    private String imgUrl;

    @SerializedName("model")
    @Expose
    private String model;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("brand")
    @Expose
    private String brand;

    @SerializedName("info")
    @Expose
    private String info;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
