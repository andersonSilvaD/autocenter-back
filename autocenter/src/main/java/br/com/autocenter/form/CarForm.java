package br.com.autocenter.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.autocenter.model.Brand;
import br.com.autocenter.model.Car;
import lombok.Data;

//Não e necessario validar os outros campos, 
//pois seu valor vem da tag "select" do html
@Data
public class CarForm {

	private String brand;
	@NotNull @NotEmpty
	private String model;
	@NotNull @NotEmpty
	private String yearOfFabrication;
	@NotNull @NotEmpty
	private String color;
	@NotNull @NotEmpty
	private String price;

	//converte os dados do formulario em um objeto do tipo carro
	public Car convert(Brand brand2) {
		Car car = new Car(brand2,model,price,yearOfFabrication,color);
		return car;
	}

	public String getYearOfFabrication() {
		return yearOfFabrication;
	}

	public String getColor() {
		return color;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getPrice() {
		return price;
	}
	
	
}
