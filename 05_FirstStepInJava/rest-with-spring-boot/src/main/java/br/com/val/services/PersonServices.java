package br.com.val.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.val.exceptions.ResourceNotFoundException;
import br.com.val.model.Person;
import br.com.val.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		logger.info("Finding all people!");
		return repository.findAll();
	}
	
	public Person create(Person person) {
		
		logger.info("Creatig one person!");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person!");
		
		Person entity = repository.findById(person.getId())		
				.orElseThrow(() -> new ResourceNotFoundException("No records found fr this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		Person entity = repository.findById(id)		
				.orElseThrow(() -> new ResourceNotFoundException("No records found fr this ID"));
		
		repository.delete(entity);
	}

	public Person findByID(Long id) {
		
		logger.info("Finding one person!");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found fr this ID"));
	}
}
