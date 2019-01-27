package com.fangbo.spring.spel;

public class Car {
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    private String brand;
    private String price;
    private String speed;

    public Car(String brand, String price, String speed) {
        this.brand = brand;
        this.price = price;
        this.speed = speed;
    }



    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }
}
