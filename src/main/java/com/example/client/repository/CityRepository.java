package com.example.client.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.client.model.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
	
	@Query("select c from City c where lower (c.name) like lower (concat('%',:name,'%'))")
	Page<City> findByName(@Param("name") String cityName, Pageable page);
	
	@Query("select c from City c where lower (c.name) like lower (concat('%',:state,'%'))")
	Page<City> findByState(@Param("state") String stateName, Pageable page);
	
	City findByNameIgnoreCase(String name);
}
