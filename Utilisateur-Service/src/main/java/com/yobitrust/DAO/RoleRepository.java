package com.yobitrust.DAO;

import java.util.Optional;

import com.yobitrust.Models.ERole;
import com.yobitrust.Models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface RoleRepository extends MongoRepository<Role, String> {
	
	Optional<Role> findByName(ERole name);
}