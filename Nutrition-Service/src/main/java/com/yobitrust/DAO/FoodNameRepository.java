package com.yobitrust.DAO;

import com.yobitrust.Models.Food;
import com.yobitrust.Models.FoodName;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface FoodNameRepository extends MongoRepository<FoodName, String>{

	public List<FoodName> findByNameContaining(String name);
	public Optional<FoodName> findByName(String name);
}
