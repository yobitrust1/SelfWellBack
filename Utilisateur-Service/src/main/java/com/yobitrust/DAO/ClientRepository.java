package com.yobitrust.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yobitrust.Models.Client;
import com.yobitrust.Models.User;

public interface ClientRepository extends MongoRepository<Client, String> {
	
	Client findByUser(User user);
}
