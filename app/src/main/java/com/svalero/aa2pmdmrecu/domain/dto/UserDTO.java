package com.svalero.aa2pmdmrecu.domain.dto;

import androidx.room.ColumnInfo;

public class UserDTO {

    private String name;
    private String surname;
    private String dni;
    private String phone;
    private String adress;
    private float latitude;
    private float longitude;
    private String userImage;


    public UserDTO(String name, String surname, String dni, String phone, String adress, float latitude, float longitude, String userImage) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.phone = phone;
        this.adress = adress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.userImage = userImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public UserDTO(){

    }
}
