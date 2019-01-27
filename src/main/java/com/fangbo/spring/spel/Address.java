package com.fangbo.spring.spel;

public class Address {
    public Address() {
        System.out.println("Addres Constructor------");
    }

    public String getProvince() {
        return province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    private String province;
    private String street;
}
