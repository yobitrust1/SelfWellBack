package com.yobitrust.DAO;


import com.yobitrust.Models.Bmi;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface BmiRepository extends MongoRepository<Bmi, String>{
	
	
	
	public Bmi findByIdBmi(String idBmi);
	//public Bmi findByBmiIdUser(String idUser);
	public List<Bmi> findByIdUser(String idUser);
	
	//@Query("{ 'idUser' : ?0 }")
	public  Optional<Bmi> findFirstByIdUserOrderByBmiDateDesc(String idUser);
	
	public Optional<Bmi> findByIdUserAndBmiDate(String idUser, Date bmiDate);
	
}
