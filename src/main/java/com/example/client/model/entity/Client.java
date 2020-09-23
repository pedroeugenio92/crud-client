package com.example.client.model.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255)
	private String name;
	
	@Column(length = 1)
	private String gender;

	private Date birth;
	
	private int age;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@PrePersist
    public void prePersist() {
		Calendar date = Calendar.getInstance();
		date.setTime(birth);
		Calendar today = Calendar.getInstance();
		int ageCalculated = today.get(Calendar.YEAR) - date.get(Calendar.YEAR);
		if (today.get(Calendar.MONTH) < date.get(Calendar.MONTH) || 
				((today.get(Calendar.MONTH) == date.get(Calendar.MONTH)) && (today.get(Calendar.DAY_OF_MONTH) < date.get(Calendar.DAY_OF_MONTH)))) {
			ageCalculated--;
		}
		age = ageCalculated;		
    }

}
