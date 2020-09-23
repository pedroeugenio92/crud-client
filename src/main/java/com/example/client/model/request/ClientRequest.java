package com.example.client.model.request;

import java.util.Date;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ClientRequest {

	@NotNull(message = "Nome é obrigatório")
	private String name;
	
	@NotNull(message = "Sexo é obrigatório")
	private String gender;
	
	@NotNull(message = "Data de aniversário é obrigatório")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date birth;
	
	@NotNull(message = "Cidade é obrigatório")
	private String cityName;
}
