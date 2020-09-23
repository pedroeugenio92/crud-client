package com.example.client.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.client.service.CityService;
import com.example.client.model.request.CityRequest;
import com.example.client.model.response.CityResponse;

@RestController
@RequestMapping({"/city"})
public class CityController {
	
	@Autowired
	private CityService service;

	@GetMapping
	public ResponseEntity<Page<CityResponse>> findAll(Pageable page){
		return ResponseEntity.ok(service.findAll(page));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CityResponse> findByName(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping("/name")
	public ResponseEntity<Page<CityResponse>> findByName(@RequestParam String name, Pageable page){
		return ResponseEntity.ok(service.findByName(name, page));
	}
	
	@GetMapping("/state")
	public ResponseEntity<Page<CityResponse>> findByState(@RequestParam String stateName, Pageable page){
		return ResponseEntity.ok(service.findByStateName(stateName, page));
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> findByState(@RequestBody @Valid CityRequest request){
		try {
			return ResponseEntity.ok(service.save(request));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
