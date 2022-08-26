package com.svalero.aa2pmdmrecu.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Entity
public class Car {


    @PrimaryKey(autoGenerate = false)
    private long id;     // TODO en la API es LONG!!!
    @ColumnInfo
    private String brand;
    @ColumnInfo
    private String model;
    @ColumnInfo
    private String color;
    @ColumnInfo
    private String horsePower;
    @ColumnInfo
    private boolean favourite;
    @Ignore
    private User user;   // TODO en API contiene un objeto user entero, sacar el ID


    @Ignore
    public Car(long id, String brand, String model, String color, String horsePower,boolean favourite, User user) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.favourite = favourite;
        this.user = user;
    }

    @Ignore
    public Car (Car car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.horsePower = car.getHorsePower();
        this.favourite = car.getFavourite();
        this.user = car.getUser();
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    public boolean getFavourite() {return favourite;}

    public void setFavourite(boolean favourite) {this.favourite = favourite;}


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Car() {
    }




























}
