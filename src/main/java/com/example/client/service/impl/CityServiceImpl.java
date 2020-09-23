package com.example.client.service.impl;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.client.model.entity.City;
import com.example.client.model.request.CityRequest;
import com.example.client.model.response.CityResponse;
import com.example.client.repository.CityRepository;
import com.example.client.service.CityService;
import com.example.client.service.mapper.CityMapper;

@Service
@Transactional
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityMapper cityMapper;
	
	@Autowired CityRepository repository;
	
	@Override
	public Page<CityResponse> findAll(Pageable page){
		Page<City> city = repository.findAll(page);
		Page<CityResponse> cityResponse = city.map(cityMapper::convertToResponse);
		return cityResponse;
	}
	
	@Override
	public CityResponse findById(Long id){
		CityResponse result = null;
		Optional<City> response = repository.findById(id);
		if(response.isPresent()) {
			result = cityMapper.convertToResponse(response.get());
		}
		return result;
	}
	
	@Override
	public Page<CityResponse> findByName(String name, Pageable page){
		Page<City> city = repository.findByName(name, page);
		Page<CityResponse> cityResponse = city.map(cityMapper::convertToResponse);
		return cityResponse;
	}
	
	@Override
	public Page<CityResponse> findByStateName(String stateName, Pageable page){
		Page<City> city = repository.findByName(stateName, page);
		Page<CityResponse> cityResponse = city.map(cityMapper::convertToResponse);
		return cityResponse;
	}
	
	@Override
	public CityResponse save(CityRequest request) {
		CityResponse result = null;
		if(!verifyCity(request.getName())) {		
			City city = cityMapper.convertToEntity(request);
			result = cityMapper.convertToResponse(repository.save(city));
		}
		return result;
	}
	
	private boolean verifyCity(String name) {
		boolean result = false;
		City city = repository.findByNameIgnoreCase(name);
		if(city != null) {
			result = true;
		}
		return result;
	}

}
