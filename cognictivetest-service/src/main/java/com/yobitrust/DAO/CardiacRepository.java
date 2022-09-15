package com.yobitrust.DAO;

import com.yobitrust.Models.Cardiac;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CardiacRepository extends MongoRepository<Cardiac, String>{

	public List<Cardiac> findByIdUser(String idUser);
}