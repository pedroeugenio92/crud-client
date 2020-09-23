package com.example.client.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.client.model.entity.Client;
import com.example.client.model.request.ClientRequest;
import com.example.client.model.response.ClientResponse;

@Component
public class ClientMapper {

	@Autowired
	private ModelMapper mapper;

	public Client convertToEntity(ClientRequest clientRequest) {
		return mapper.map(clientRequest, Client.class);
	}

	public ClientResponse convertToResponse(Client client) {

		return mapper.map(client, ClientResponse.class);
	}
}
