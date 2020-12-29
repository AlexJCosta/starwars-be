package com.starwars.entites;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document(collection = "planet")
public class Planet {
	
	@Id	
	@JsonProperty("id")
	private String id;
	
	private String name;
	
	private String climate;
	
	private String terrain;
	
	private List<?> films;

}
