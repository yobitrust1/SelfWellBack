package com.yobitrust.DAO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yobitrust.Models.BloodAnalyse;
import com.yobitrust.Models.Bmi;


public interface BloodAnalyseRepository extends MongoRepository<BloodAnalyse, String>{
	public BloodAnalyse findByIdBloodAnalyse(String idBloodAnalyse);
	public List<BloodAnalyse> findByIdUser(String idUser);
	public Optional<BloodAnalyse> findByIdUserAndBloodAnalysisDate(String idUser, String bloodAnalysisDate);
}
