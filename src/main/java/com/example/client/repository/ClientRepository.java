package com.example.client.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.client.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{
	
	@Query("select c from Client c where lower (c.name) like lower (concat('%',:name,'%'))")
	Page<Client> findByName(@Param("name") String cityName, Pageable page);
	
	Client findByNameIgnoreCase(String name);

}
