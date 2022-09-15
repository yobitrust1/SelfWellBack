package com.yobitrust.DAO;

import java.util.Optional;
import java.util.Set;

import com.yobitrust.Models.Role;
import com.yobitrust.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmail(String email);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	User findByEmailIgnoreCase(String email);
	
	Boolean findIsEnabledByEmail(String email);
	
	Optional<User> findByRoles(Set<Role> roles);
}