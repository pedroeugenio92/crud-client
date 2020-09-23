package com.example.client.service.impl;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.client.model.entity.Client;
import com.example.client.model.request.ClientRequest;
import com.example.client.model.request.ClientUpdateRequest;
import com.example.client.model.response.ClientResponse;
import com.example.client.repository.CityRepository;
import com.example.client.repository.ClientRepository;
import com.example.client.service.ClientService;
import com.example.client.service.mapper.ClientMapper;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	
	
	@Autowired
	private ClientMapper clientMapper;
	
	@Autowired 
	private ClientRepository repository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public Page<ClientResponse> findAll(Pageable page){
		Page<Client> client = repository.findAll(page);
		Page<ClientResponse> clientResponse = client.map(clientMapper::convertToResponse);
		return clientResponse;
	} 
	
	@Override
	public ClientResponse findById(Long id){
		ClientResponse result = null;
		Optional<Client> response = repository.findById(id);
		if(response.isPresent()) {
			result = clientMapper.convertToResponse(response.get());
		}
		return result;
	}
	
	@Override
	public Page<ClientResponse> findByName(String name, Pageable page){
		Page<Client> client = repository.findByName(name, page);
		Page<ClientResponse> clientResponse = client.map(clientMapper::convertToResponse);
		return clientResponse;
	}
	
	@Override
	public ClientResponse save(ClientRequest request) {
		ClientResponse result = null;
		if(!verifyClientName(request.getName())) {		
			Client client = clientMapper.convertToEntity(request);
			client.setCity(cityRepository.findByNameIgnoreCase(request.getCityName()));
			result = clientMapper.convertToResponse(repository.save(client));
		}
		return result;
	}
	
	@Override
	public ClientResponse updateName(Long id,ClientUpdateRequest request) {
		ClientResponse result = null;
		
		Optional<Client> clientSearch = repository.findById(id);
		if(clientSearch.isPresent()) {
			Client client = clientSearch.get();
			if(!verifyClientName(request.getName())) {		
				client.setName(request.getName());
				result = clientMapper.convertToResponse(repository.save(client));
			}
		}
		
		return result;
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
	private boolean verifyClientName(String name) {
		boolean result = false;
		Client client = repository.findByNameIgnoreCase(name);
		if(client != null) {
			result = true;
		}
		return result;
	}
}
