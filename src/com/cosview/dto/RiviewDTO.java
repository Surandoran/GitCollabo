package com.cosview.dto;

public class RiviewDTO extends DTO{
        private String name;
        private String price;
        private String volume;
        private String riview;

    public RiviewDTO(String name, String price, String volume, String riview) {
        this.name = name;
        this.price = price;
        this.volume = volume;
        this.riview = riview;
    }
    public RiviewDTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getRiview() {
        return riview;
    }

    public void setRiview(String riview) {
        this.riview = riview;
    }

    @Override
    public String toString() {
        return "RiviewDTO{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", volume='" + volume + '\'' +
                ", riview='" + riview + '\'' +
                '}';
    }
}
