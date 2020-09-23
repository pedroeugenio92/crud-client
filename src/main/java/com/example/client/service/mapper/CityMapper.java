package com.example.client.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.client.model.entity.City;
import com.example.client.model.request.CityRequest;
import com.example.client.model.response.CityResponse;

@Component
public class CityMapper {

	@Autowired
	private ModelMapper mapper;
	
	public City convertToEntity(CityRequest cityRequest) {
		return mapper.map(cityRequest, City.class);
	}
	
	public CityResponse convertToResponse(City city) {
		
		return mapper.map(city, CityResponse.class);
	}
}
