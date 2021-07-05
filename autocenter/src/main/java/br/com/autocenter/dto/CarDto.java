package br.com.autocenter.dto;

import java.math.BigDecimal;

import br.com.autocenter.model.Brand;
import br.com.autocenter.model.Car;

public class CarDto {

	private String id;
	private Brand brand;
	private String model;
	private String price;
	
	public CarDto() {}

	public CarDto(Car car) {
		brand = car.getBrand();
		model = car.getModel();
		price = car.getPrice();
	}
	
	public String getId() {
		return this.id;
	}

	public Brand getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getPrice() {
		return price;
	}
}
