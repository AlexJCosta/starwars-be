package com.starwars.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.entites.Planet;
import com.starwars.repository.PlanetRepository;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository repository;

	public List<Planet> findAll() {
		return repository.findAll();
	}
	
	public Planet findById(String id) {
		Optional<Planet> obj = repository.findById(id);
		if (obj.isPresent()) return obj.get();
		return null; 
	}
	
	public Planet findByName(String name) {
		Optional<Planet> obj = repository.findByName(name);
		if (obj.isPresent()) return obj.get();
		return null; 
	}

	public Planet save(Planet obj) {
		return repository.save(obj);
	}
	
	public void delete(Planet obj) {
		repository.delete(obj);
	}
}
