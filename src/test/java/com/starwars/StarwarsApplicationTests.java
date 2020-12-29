package com.starwars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.starwars.entites.Planet;
import com.starwars.repository.PlanetRepository;

@SpringBootTest
class StarwarsApplicationTests {
	
	@Autowired
	private PlanetRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void getByName() {
		Planet p = getPlanet();
		assertEquals("Dagobah", p.getName());
	}
	
	@Test
	public void create() {
		Planet p = new Planet();
		p.setName("New Planet");
		p.setClimate("Climate");
		p.setTerrain("Terrain");
		
		Planet newPlanet = repository.save(p);
		assertEquals(p.getName(), newPlanet.getName());	
	}
	
	@Test
	public void update() {
		Planet p = getPlanet();
		p.setClimate("new");
		
		repository.save(p);
		
		Planet pUpdated = getPlanet();
		assertEquals("new", pUpdated.getClimate());
	}
	
	@Test
	public void delete() {
		Planet p = getPlanet();
		repository.delete(p);
				
		assertNull(getPlanet());		
	}	
	
	public Planet getPlanet() {
		String nome = "Dagobah";
		return getPlanetInDataBase(nome);
	}

	private Planet getPlanetInDataBase(String nome) {
		return repository.findByName(nome).get();		
	}

}
