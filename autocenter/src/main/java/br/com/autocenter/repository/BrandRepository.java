package br.com.autocenter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.autocenter.model.Brand;

public interface BrandRepository extends MongoRepository<Brand, String>{

	Optional<Brand> findByName(String name);
}
