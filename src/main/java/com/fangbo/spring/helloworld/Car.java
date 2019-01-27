package com.fangbo.spring.helloworld;
public class Car {

    private String company;
    private String brand;

    public void setCompany(String company) {
        this.company = company;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private int maxSpeed;
    private float price;

    public Car(String company, String brand, float price) {
        super();
        this.company = company;
        this.brand = brand;
        this.price = price;
    }

    public Car(String company, String brand, int maxSpeed) {
        super();
        this.company = company;
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public Car(String company, String brand, int maxSpeed, float price) {
        super();
        this.company = company;
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car [company=" + company + ", brand=" + brand + ", maxSpeed="
            + maxSpeed + ", price=" + price + "]";
}
}

