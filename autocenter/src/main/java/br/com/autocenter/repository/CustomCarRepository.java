package br.com.autocenter.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import br.com.autocenter.form.CarSearchForm;
import br.com.autocenter.model.Car;


@Service //pra ser injetado pelo spring
public class CustomCarRepository {
	
	
	public Query queryBuilder(CarSearchForm form) {
		  Query query = new Query();
		  
		  if(!form.getBrand().equals("undefined"))
			  query.addCriteria(Criteria.where("brand.name").is(form.getBrand()));
		  if(!form.getModel().equals("undefined"))
			  query.addCriteria(Criteria.where("model").is(form.getModel()));
		  if(!form.getYearOfFabrication().equals("undefined"))
			  query.addCriteria(Criteria.where("yearOfFabrication").is(form.getYearOfFabrication()));
		  if(!form.getColor().equals("undefined"))
			  query.addCriteria(Criteria.where("color").is(form.getColor()));
		  return query;
	}
	

}
