package com.yobitrust.DAO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yobitrust.Models.Breakfast;
import com.yobitrust.Models.Food;

public interface BreakfastRepository extends MongoRepository<Breakfast, String>{

	public Optional<Breakfast> findByIdUserAndBreakfastDate(String idUser, String BreakfastDate);
	public List<Breakfast> findByBreakfastDate(String breakfastDate);
	//public void deleteFoodByIdAndFood(String id, List<Food> Food);
	
}
