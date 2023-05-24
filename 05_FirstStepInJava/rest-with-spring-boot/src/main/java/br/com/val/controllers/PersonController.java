package br.com.val.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.val.data.vo.v1.PersonVO;
import br.com.val.data.vo.v2.PersonVOV2;
import br.com.val.services.PersonServices;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	
	private static final String APPLICATION_YML = "application/x-yaml";
	private static final String APPLICATION_JSON = "application/json";
	private static final String APPLICATION_XML = "application/xml";
	
	@Autowired
	private PersonServices service;
	
	@GetMapping(produces = { APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
	public List<PersonVO> findAll(){
		return service.findAll();
	}

	@GetMapping(value = "/{id}",produces = { APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
	public PersonVO findById(@PathVariable(value = "id") Long id){
		return service.findByID(id);
	}
	
	@PostMapping(
			consumes = { APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
			produces = { APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
	public PersonVO create(@RequestBody PersonVO person){
		return service.create(person);
	}
	
	@PostMapping(value = "/v2", 
			consumes = { APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
			produces = { APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person){
		return service.createV2(person);
	}
	
	@PutMapping(
			consumes = { APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML},
			produces = { APPLICATION_JSON, APPLICATION_XML, APPLICATION_YML})
	public PersonVO update(@RequestBody PersonVO person){
		return service.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
