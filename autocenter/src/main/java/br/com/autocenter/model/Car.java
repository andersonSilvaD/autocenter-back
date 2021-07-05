package br.com.autocenter.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.autocenter.form.CarForm;
import br.com.autocenter.form.PatchForm;
import lombok.Data;

@Document
@Data
public class Car {
	@Id
	private String id;
	private Brand brand;
	private String model;
	private String name;
	private String yearOfFabrication;
	private String price;
	private String color;
	
	public Car() {}
	
	public Car(Brand brand, String model, String price,String yearOfFabrication,String color) {
		
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.yearOfFabrication = yearOfFabrication;
		this.color = color;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYearOfFabrication() {
		return yearOfFabrication;
	}
	public void setYearOfFabrication(String yearOfFabrication) {
		this.yearOfFabrication = yearOfFabrication;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getId() {
		return id;
	}

	public void setPatch(PatchForm form) {
		this.color = form.getColor();
		this.yearOfFabrication = form.getYearOfFabrication();
		this.price = form.getPrice();
	}
	
	
}
