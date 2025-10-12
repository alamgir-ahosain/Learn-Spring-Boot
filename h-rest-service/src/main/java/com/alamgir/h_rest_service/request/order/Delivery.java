package com.alamgir.h_rest_service.request.order;

public class Delivery {
    private String streetName;
    private String buildingName;
    private int flatNumber;
    private String city;
    private String state;
    private int pincode;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Delivery [streetName=" + streetName + ", buildingName=" + buildingName + ", flatNumber=" + flatNumber
                + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
    }

    
}