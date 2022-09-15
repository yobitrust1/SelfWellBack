package com.yobitrust.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yobitrust.Models.BioImpedance;


public interface BioImpedanceRepository extends MongoRepository<BioImpedance, String>{

	public List<BioImpedance> findByIdUser(String idUser);
}
