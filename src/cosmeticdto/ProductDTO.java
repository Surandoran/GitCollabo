package cosmeticdto;

import javax.swing.*;

public class ProductDTO extends DTO {
    private String name;
    private String brand;
    private String price;
    private String volume;
    private String code;

    public ProductDTO(String name, String brand, String price, String volume, String code) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.volume = volume;
        this.code = code;
    }
    public ProductDTO(String code){
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
