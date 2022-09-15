package com.yobitrust.DAO;

import com.yobitrust.Models.ConfirmationToken;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ConfirmationTokenRepository extends MongoRepository<ConfirmationToken, String> {
	
	ConfirmationToken findByConfirmationToken(String confirmationToken);

}
