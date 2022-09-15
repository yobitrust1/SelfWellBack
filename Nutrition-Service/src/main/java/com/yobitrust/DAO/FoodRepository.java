package com.yobitrust.DAO;

import java.util.List;
import java.util.Optional;

import com.yobitrust.Models.FoodName;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.yobitrust.Models.Food;


public interface FoodRepository  extends MongoRepository<Food, String>{

	public List<Food> findByNameContaining(String name);
	public Optional<Food> findByName(String name);
}
