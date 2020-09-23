package com.example.client.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.client.model.request.CityRequest;
import com.example.client.model.response.CityResponse;

@Component(value = "CityService")
public interface CityService {
	
	public Page<CityResponse> findAll(Pageable page);
	
	public CityResponse findById(Long id);
	
	public Page<CityResponse> findByName(String name, Pageable page);
	
	public Page<CityResponse> findByStateName(String stateName, Pageable page);
	
	public CityResponse save(CityRequest request);
}
