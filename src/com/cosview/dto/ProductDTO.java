package com.cosview.dto;

public class ProductDTO {
 private String name;
 private String brand;
 private int price;
 private String volume;

 
 //생성자
 public ProductDTO(String name, String brand, int price, String volume) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.volume = volume;
	}



 
 //Getter and Setter
 public String getname() {
		return name;
	}


	public void setname(String name) {
		this.name = name;
	}


	public String getbrand() {
		return brand;
	}


	public void setbrand(String brand) {
		this.brand = brand;
	}


	public int getprice() {
		return price;
	}


	public void setprice(int price) {
		this.price = price;
	}


	public String getvolume() {
		return volume;
	}


	public void setvolume(String volume) {
		this.volume = volume;				
	}


	//toString()

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", brand=" + brand + ", price=" + price + ", volume=" + volume + "]";
	}
	
	
	
}
