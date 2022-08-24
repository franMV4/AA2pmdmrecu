package com.svalero.aa2pmdmrecu.domain.dto;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class GarageDTO {


    private String street;
    private String city;
    private String postalCode;
    private String owner;
    private int capacity;


    public GarageDTO(String street, String city, String postalCode, String owner, int capacity) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.owner = owner;
        this.capacity = capacity;
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

    public GarageDTO(){

    }
}
