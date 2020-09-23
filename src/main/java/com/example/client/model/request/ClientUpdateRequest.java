package com.example.client.model.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ClientUpdateRequest {
	@NotNull(message = "Nome é obrigatório")
	private String name;
}
