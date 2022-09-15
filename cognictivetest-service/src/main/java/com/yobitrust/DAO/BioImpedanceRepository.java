package com.yobitrust.DAO;

import com.yobitrust.Models.BioImpedance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface BioImpedanceRepository extends MongoRepository<BioImpedance, String>{

	public List<BioImpedance> findByIdUser(String idUser);
}
