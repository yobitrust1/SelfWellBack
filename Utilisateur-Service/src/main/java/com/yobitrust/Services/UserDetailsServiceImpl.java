package com.yobitrust.Services;

import com.yobitrust.DAO.RoleRepository;
import com.yobitrust.DAO.UserRepository;
import com.yobitrust.Models.Role;
import com.yobitrust.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
   
	@Autowired
	RoleRepository roleRepository;


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));

		return UserDetailsImpl.build(user);
	}
	
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

}