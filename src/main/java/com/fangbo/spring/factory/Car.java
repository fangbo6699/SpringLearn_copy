package com.fangbo.spring.factory;

public class Car {
    private String brand;
    private String price;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Car(String brand, String price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public Car() {
        System.out.println("Car Constructor.................");
    }

    public void setBrand(String brand) {
        this.brand = brand;
        System.out.println("public void setBrand(String brand)");
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void inittet(){
        System.out.println("initet ..................");
    }
    public void desdroy(){
        System.out.println("desdroy ..................");
    }
}
