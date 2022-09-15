package com.yobitrust.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yobitrust.Models.Lunch;


public interface LunchRepository extends MongoRepository<Lunch, String>{

	public Optional<Lunch> findByIdUserAndLunchDate(String idUser, String lunchDate);
	public List<Lunch> findByLunchDate(String lunchDate);
}
