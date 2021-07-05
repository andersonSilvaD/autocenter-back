package br.com.autocenter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.autocenter.model.Brand;
import br.com.autocenter.repository.BrandRepository;

@RequestMapping("/brand")
@RestController
public class BrandController {

	@Autowired
	private BrandRepository repository;
	
	@GetMapping
	public List getBrand() {
		return repository.findAll();
	}
	//seta valores iniciais para o BD
	//deve haver algum jeito mais elegante de se fazer isso
	@PostConstruct
	public void initials() {
		repository.deleteAll();
		List<String> modelListFord = new ArrayList();
		List<String> modelListFiat = new ArrayList();
		List<String> modelListWolks = new ArrayList();
		List<String> modelListGM = new ArrayList();
		
		
		modelListFord.add("Ka");
		modelListFord.add("Fiesta");
		modelListFord.add("Focus");
		modelListFord.add("Ranger");
		Brand ford = new Brand("Ford", modelListFord);
		repository.save(ford);
		
		modelListFiat.add("Uno");
		modelListFiat.add("Palio");
		modelListFiat.add("Estrada");
		modelListFiat.add("Toro");
		Brand fiat = new Brand("Fiat", modelListFiat);
		repository.save(fiat);
		
		modelListWolks.add("Gol");
		modelListWolks.add("Jetta");
		modelListWolks.add("Up");
		modelListWolks.add("Saveiro");
		Brand wolks = new Brand("Wolksvagen", modelListWolks);
		repository.save(wolks);
		
		modelListGM.add("Corsa");
		modelListGM.add("Celta");
		modelListGM.add("Onix");
		modelListGM.add("Agile");
		Brand gm = new Brand("General Motors", modelListGM);
		repository.save(gm);
	}
}
