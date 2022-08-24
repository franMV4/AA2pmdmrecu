package com.svalero.aa2pmdmrecu.domain.dto;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;

import java.util.Objects;

public class ReparationDTOAdapter implements Comparable {

    private static String dateOfDelivery;
    private long id;     // Reparation
    private int cost;     // Reparation
    private String repairedPart;  // Reparation
    private int numeroMecanicos;  // Reparation

   // private String dateOfDelivery; // Reparation
    private String pickUpDate; // Reparation
    private String userNameSurname;  // User
    private String carBrandModel;    // User
    private String carHorsePower;    // Computer

    @Ignore
    public ReparationDTOAdapter() {
    }

    public ReparationDTOAdapter(long id,int cost, String repairedPart, String dateOfDelivery, String pickUpDate, String userNameSurname, String carBrandModel, String carHorsePower) {
        this.id = id;
        this.cost = cost;
        this.repairedPart = repairedPart;
        this.dateOfDelivery = dateOfDelivery;
        this.pickUpDate = pickUpDate;
        this.userNameSurname = userNameSurname;
        this.carBrandModel = carBrandModel;
        this.carHorsePower = carHorsePower;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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

    public String getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getUserNameSurname() {
        return userNameSurname;
    }

    public void setUserNameSurname(String userNameSurname) {
        this.userNameSurname = userNameSurname;
    }

    public String getCarBrandModel() {
        return carBrandModel;
    }

    public void setCarBrandModel(String carBrandModel) {
        this.carBrandModel = carBrandModel;
    }

    public String getCarHorsePower() {
        return carHorsePower;
    }

    public void setCarHorsePower(String carHorsePower) {
        this.carHorsePower = carHorsePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReparationDTOAdapter reparationDTOAdapter = (ReparationDTOAdapter) o;
        return id == reparationDTOAdapter.id && dateOfDelivery.equals(ReparationDTOAdapter.dateOfDelivery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfDelivery);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "OrderDTOAdapter{" +
                "id=" + id +
                ", date=" + dateOfDelivery +
                ", userNameSurname='" + userNameSurname + '\'' +
                ", computerBrandModel='" + carBrandModel + '\'' +
                ", description='" + repairedPart + '\'' +
                '}';
    }



    public void setComputerRam(String computerRam) {
        this.carHorsePower = computerRam;
    }
}
