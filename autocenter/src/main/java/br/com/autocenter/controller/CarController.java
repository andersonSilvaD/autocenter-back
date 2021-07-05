package br.com.autocenter.controller;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.autocenter.dto.CarDto;
import br.com.autocenter.form.CarForm;
import br.com.autocenter.form.CarSearchForm;
import br.com.autocenter.form.PatchForm;
import br.com.autocenter.model.Brand;
import br.com.autocenter.model.Car;
import br.com.autocenter.repository.BrandRepository;
import br.com.autocenter.service.CarServiceImpl;
//todos operacionais, faltam apenas as validações
//se possivel, mudar o tipo do id da classe "car",pois String esta feio
/*"preço" teve de ser tipado como String, pois todos os valores numericos apresentaram falha
*/
@RestController
@CrossOrigin
@RequestMapping("/veiculos")
public class CarController {

	@Autowired
	private CarServiceImpl carService;
	@Autowired
	private BrandRepository brandRepository;

	// create
	@PostMapping
	public ResponseEntity<CarDto> insertNewVehicle(@RequestBody @Valid CarForm form, UriComponentsBuilder uriBuilder) {
		String brandName = form.getBrand();
		Brand brand = brandRepository.findByName(brandName).get();
		
		Car car =  carService.insertVehicle(form,brand);
		URI uri = uriBuilder.path("/veiculos/{id}").buildAndExpand(car.getId()).toUri();
		return ResponseEntity.created(uri).body(new CarDto(car));
	}
	@GetMapping
	public List<Car> carList() {
		return carService.carList();
	}
	@GetMapping("/buscaporid")
	public Car byId(String id) {
		return carService.getById(id);
	}
	@PutMapping("/{id}")
	public void updateCarInformation(@RequestBody @Valid PatchForm form, @PathVariable String id) {
		Car car = carService.patch(form,id);
	}
	@CrossOrigin
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		carService.delete(id);
	}
	@GetMapping("/busca") // busca pelo formulario de parametros
	public List<Car> buscaCarros(String brand, String model, String color,
			String yearOfFabrication) {
		CarSearchForm form = new CarSearchForm(brand,model,yearOfFabrication,color);
		List<Car> listaDeCarros = carService.finByParams(form);
		return listaDeCarros;
	}
}
