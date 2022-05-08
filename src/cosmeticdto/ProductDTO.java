package cosmeticdto;

import javax.swing.*;

public class ProductDTO extends DTO {
    private String name;
    private String brand;
    private int price;
    private String volume;
    private int code;
    
    public ProductDTO(String name, String brand, int price, String volume, int code) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.volume = volume;
        this.code = code;
    }
    public ProductDTO(int code){
        this.code = code;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", volume='" + volume + '\'' +
                ", code=" + code +
                '}';
    }
}
