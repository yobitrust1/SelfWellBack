package com.yobitrust.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yobitrust.Models.Doctor;
import com.yobitrust.Models.User;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

	Doctor findByUser(User user);
	
}
