package com.starwars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.entites.Planet;
import com.starwars.services.PlanetService;

@RestController
@RequestMapping("/planets")
public class PlanetController {
	
	@Autowired
	private PlanetService service;
	
	@GetMapping
	public ResponseEntity<List<Planet>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Planet> getById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Planet> getByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findByName(name));
	}
	
	@PostMapping
	public ResponseEntity<Planet> create(@RequestBody Planet obj) {
        return ResponseEntity.status(HttpStatus.OK).body(service.save(obj));
	}
	
	@PutMapping
	public ResponseEntity<Planet> update(@RequestBody Planet obj) {
        return ResponseEntity.status(HttpStatus.OK).body(service.save(obj));
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Planet obj) {
		service.delete(obj);
        return ResponseEntity.status(HttpStatus.OK).build();
	}

}
