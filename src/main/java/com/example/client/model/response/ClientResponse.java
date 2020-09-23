package com.example.client.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ClientResponse {
	private Long id;
	
	private String name;
	
	private String gender;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date birth;
	
	private Long age;
	
	private String cityName;
}
