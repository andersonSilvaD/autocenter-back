package br.com.autocenter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import br.com.autocenter.model.Car;

public interface CarRepository extends MongoRepository<Car, String> {

	@org.springframework.data.mongodb.repository.Query("{?0}")
	Optional<List<Car>> findByParams(String query);
}
