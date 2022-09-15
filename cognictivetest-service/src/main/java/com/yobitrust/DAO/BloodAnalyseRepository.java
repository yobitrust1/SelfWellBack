package com.yobitrust.DAO;

import com.yobitrust.Models.BloodAnalyse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface BloodAnalyseRepository extends MongoRepository<BloodAnalyse, String>{
	public BloodAnalyse findByIdBloodAnalyse(String idBloodAnalyse);
	public List<BloodAnalyse> findByIdUser(String idUser);
	public Optional<BloodAnalyse> findByIdUserAndBloodAnalysisDate(String idUser, String bloodAnalysisDate);
}
