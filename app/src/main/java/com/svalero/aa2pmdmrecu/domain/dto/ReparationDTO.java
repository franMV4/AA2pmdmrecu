package com.svalero.aa2pmdmrecu.domain.dto;

public class ReparationDTO {





    private String repairedPart;
    private int numeroMecanicos;
    private String pickUpDate;
    private String dateOfDelivery;
    private int cost;
    private boolean delivered;

    private long garage;
    private long car;


    public ReparationDTO(String repairedPart, int numeroMecanicos, String pickUpDate, String dateOfDelivery, int cost, boolean delivered, long garage, long car) {
        this.repairedPart = repairedPart;
        this.numeroMecanicos = numeroMecanicos;
        this.pickUpDate = pickUpDate;
        this.dateOfDelivery = dateOfDelivery;
        this.cost = cost;
        this.delivered = delivered;
        this.garage = garage;
        this.car = car;
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

    public long getGarage() {
        return garage;
    }

    public void setGarage(long garage) {
        this.garage = garage;
    }

    public long getCar() {
        return car;
    }

    public void setCar(long car) {
        this.car = car;
    }


    public ReparationDTO(){

    }
}
