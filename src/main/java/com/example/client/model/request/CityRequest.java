package com.example.client.model.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CityRequest {
	
	@NotNull(message = "Name é obrigatório")
	private String name;
	
	@NotNull(message = "Estado é obrigatório")
	private String state;
}
