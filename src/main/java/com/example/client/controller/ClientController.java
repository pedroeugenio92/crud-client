package com.example.client.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.model.request.ClientRequest;
import com.example.client.model.request.ClientUpdateRequest;
import com.example.client.model.response.ClientResponse;
import com.example.client.service.ClientService;

@RestController
@RequestMapping({"/client"})
public class ClientController {
	
	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<Page<ClientResponse>> findAll(Pageable page){
		return ResponseEntity.ok(service.findAll(page));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientResponse> findByName(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping("/name")
	public ResponseEntity<Page<ClientResponse>> findByName(@RequestParam String name, Pageable page){
		return ResponseEntity.ok(service.findByName(name, page));
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid ClientRequest request){
		try {
			return ResponseEntity.ok(service.save(request));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		try {
			service.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> save(@PathVariable("id") Long id,@RequestBody @Valid ClientUpdateRequest request){
		try {
			return ResponseEntity.ok(service.updateName(id, request));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	

}
