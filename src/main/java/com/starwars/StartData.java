package com.starwars;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.starwars.entites.Planet;

@Component
public class StartData implements CommandLineRunner {
	
	private final MongoTemplate mongo;

	public StartData(MongoTemplate template) {
		this.mongo = template;		
	}

	@Override
	public void run(String... args) throws Exception {
		for (Integer i = 1; i < 10; i++) {		
			try {
				String string = Unirest.get("https://swapi.dev/api/planets/{id}")
						.routeParam("id", i.toString()).asJson().getBody().toString();
				
				Planet planet = new Gson().fromJson(string, Planet.class);
				
				mongo.save(planet);				
			} catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
		}
	}
}
