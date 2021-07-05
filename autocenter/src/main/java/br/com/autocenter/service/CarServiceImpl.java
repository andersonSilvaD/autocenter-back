package br.com.autocenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.autocenter.form.CarForm;
import br.com.autocenter.form.CarSearchForm;
import br.com.autocenter.form.PatchForm;
import br.com.autocenter.model.Brand;
import br.com.autocenter.model.Car;
import br.com.autocenter.repository.CarRepository;
import br.com.autocenter.repository.CustomCarRepository;

@Service
public class CarServiceImpl {

	@Autowired
	CarRepository carRepository;
	@Autowired
	CustomCarRepository customRepository;
	@Autowired
	MongoTemplate mongoTemplate;

	public Car insertVehicle(CarForm form, Brand brand) {
		Car car = form.convert(brand);
		carRepository.save(car);
		
		return car;
	}
	
	public List carList() {
		List<Car> listaDeCarros = carRepository.findAll();
		return listaDeCarros;
	}

	public void delete(String id) {
		carRepository.deleteById(id);
	}

	public Car getById(String id) {
		Optional<Car> car = carRepository.findById(id);
		return car.get();
	}
	
	public List<Car> finByParams(CarSearchForm form) {
		Query query = customRepository.queryBuilder(form);
		System.out.println("Query montada" + query.toString());
		
		return mongoTemplate.find(query, Car.class);
	}

	public Car patch(PatchForm form, String id) {
		Car car = carRepository.findById(id).get();
		car.setPatch(form);
		carRepository.save(car);
	return car;
	}
}
