package com.svalero.aa2pmdmrecu.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Entity
public class Garage {




    @PrimaryKey(autoGenerate = false)
    @NonNull
    private long id;
    @ColumnInfo
    private String street;
    @ColumnInfo
    private String city;
    @ColumnInfo
    private String postalCode;
    @ColumnInfo
    private String owner;
    @ColumnInfo
    private int capacity;

    @Ignore
    public Garage(long id, String street, String city, String postalCode, String owner, int capacity) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.owner = owner;
        this.capacity = capacity;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public Garage() {
    }

}
