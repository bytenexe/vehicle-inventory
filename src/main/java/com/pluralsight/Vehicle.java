package com.pluralsight;

public class Vehicle {

    //. Add the vehicleID, makeModel, color, odoMeterReading, and price data members

    private long vehicleId;
    private String makeModel;
    private String color;
    private int odometerReading;
    private double price;

    //. Create the constructors for data
    public Vehicle(long vehicleID, String makeModel, String color, int odometerReading, double price) {
        this.vehicleId = vehicleId;
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public String getColor() {
        return color;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public double getPrice() {
        return price;
    }

    public long getVehicleId() {
        return this.vehicleId;
    }
}
