package com.yobitrust.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yobitrust.Models.Cardiac;


public interface CardiacRepository extends MongoRepository<Cardiac, String>{

	public List<Cardiac> findByIdUser(String idUser);
}