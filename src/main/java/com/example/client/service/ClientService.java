package com.example.client.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.client.model.request.ClientRequest;
import com.example.client.model.request.ClientUpdateRequest;
import com.example.client.model.response.ClientResponse;

@Component(value = "ClientService")
public interface ClientService {
	public Page<ClientResponse> findAll(Pageable page);
	
	public ClientResponse findById(Long id);
	
	public Page<ClientResponse> findByName(String name, Pageable page);
	
	public ClientResponse save(ClientRequest request);
	
	public ClientResponse updateName(Long id,ClientUpdateRequest request);
	
	void delete(Long id);
}
