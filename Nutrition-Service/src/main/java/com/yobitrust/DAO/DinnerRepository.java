package com.yobitrust.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yobitrust.Models.Dinner;



public interface DinnerRepository extends MongoRepository<Dinner, String>{

	public Optional<Dinner> findByIdUserAndDinnerDate(String idUser, String dinnerDate);
	public List<Dinner> findByDinnerDate(String dinnerDate);
	
}
