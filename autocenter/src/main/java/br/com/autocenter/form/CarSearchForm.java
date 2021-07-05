package br.com.autocenter.form;

public class CarSearchForm {

	private String brand;
	private String model;
	private String color;
	private String yearOfFabrication;
	
	
	public CarSearchForm(String brand, String model, String yearOfFabrication,String color) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.yearOfFabrication = yearOfFabrication;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getYearOfFabrication() {
		return yearOfFabrication;
	}
	public void setYearOfFabrication(String yearOfFabrication) {
		this.yearOfFabrication = yearOfFabrication;
	}
}
