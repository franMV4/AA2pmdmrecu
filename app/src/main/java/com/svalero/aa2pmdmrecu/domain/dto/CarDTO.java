package com.svalero.aa2pmdmrecu.domain.dto;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;

import com.svalero.aa2pmdmrecu.domain.User;

public class CarDTO {


    private String brand;
    private String model;
    private String color;
    private String horsePower;
    private boolean favourite;
    private long user;   // TODO en AP

    public CarDTO() {
    }


    public CarDTO(String brand, String model, String color, String horsePower, boolean favourite, long user) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.favourite = favourite;
        this.user = user;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {this.horsePower = horsePower;}

    public boolean getFavourite() {return favourite;}

    public void setFavourite(boolean favourite) { this.favourite = favourite;}

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }
}




