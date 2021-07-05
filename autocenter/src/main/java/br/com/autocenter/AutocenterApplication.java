package br.com.autocenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.autocenter.controller.BrandController;

@SpringBootApplication
public class AutocenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutocenterApplication.class, args);
	}

}
