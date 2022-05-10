package com.cosview.dto;

public class ReviewDTO extends DTO{
        private String name;
        private String price;
        private String volume;
        private String review;

    public ReviewDTO(String name, String price, String volume, String review) {
        this.name = name;
        this.price = price;
        this.volume = volume;
        this.review = review;
    }
    public ReviewDTO(String name){
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

    public String getReview() {
        return review;
    }

    public void setReview(String riview) {
        this.review = riview;
    }

    @Override
    public String toString() {
        return "RiviewDTO{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", volume='" + volume + '\'' +
                ", riview='" + review + '\'' +
                '}';
    }
}
