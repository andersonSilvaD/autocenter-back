package br.com.autocenter.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Brand {

	@Id
	private String id;
	private String name;
	private List<String> modelList;
	
	public Brand(String name, List<String> modelList) {
		this.name = name;
		this.modelList = modelList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getModelList() {
		return modelList;
	}

	public void setModelList(List<String> modelList) {
		this.modelList = modelList;
	}
	
	
}
