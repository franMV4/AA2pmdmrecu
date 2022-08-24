package com.svalero.aa2pmdmrecu.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.svalero.aa2pmdmrecu.database.TimestampConverter;


@Entity
public class Reparation {





    @PrimaryKey(autoGenerate = false)
    @NonNull
    private long id;     // TODO en la API es LONG!!!
    @ColumnInfo
    private String repairedPart;
    @ColumnInfo
    private int numeroMecanicos;
    @ColumnInfo
    @TypeConverters({TimestampConverter.class})
    private String pickUpDate;
    @ColumnInfo
    @TypeConverters({TimestampConverter.class})
    private String dateOfDelivery;
    @ColumnInfo
    private int cost;
    @ColumnInfo
    private boolean delivered;

    @Ignore
    private Garage garage;   // TODO en API contiene un objeto user entero, sacar el ID
    @Ignore
    private Car car;   // TODO en API contiene un objeto user entero, sacar el ID


    public Reparation(long id, String repairedPart, int numeroMecanicos, String pickUpDate, String dateOfDelivery, int cost, boolean delivered, Garage garage, Car car) {
        this.id = id;
        this.repairedPart = repairedPart;
        this.numeroMecanicos = numeroMecanicos;
        this.pickUpDate = pickUpDate;
        this.dateOfDelivery = dateOfDelivery;
        this.cost = cost;
        this.delivered = delivered;
        this.garage = garage;
        this.car = car;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRepairedPart() {
        return repairedPart;
    }

    public void setRepairedPart(String repairedPart) {
        this.repairedPart = repairedPart;
    }

    public int getNumeroMecanicos() {
        return numeroMecanicos;
    }

    public void setNumeroMecanicos(int numeroMecanicos) {
        this.numeroMecanicos = numeroMecanicos;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public Reparation() {
    }


}
