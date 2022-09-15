package com.yobitrust.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yobitrust.DAO.ConfirmationTokenRepository;
import com.yobitrust.DAO.RoleRepository;
import com.yobitrust.DAO.UserRepository;
import com.yobitrust.DAO.ClientRepository;
import com.yobitrust.DAO.DoctorRepository;
import com.yobitrust.Models.Client;
import com.yobitrust.Models.ConfirmationToken;
import com.yobitrust.Models.Doctor;
import com.yobitrust.Models.ERole;
import com.yobitrust.Models.Role;
import com.yobitrust.Models.User;
import com.yobitrust.Security.jwt.JwtUtils;
import com.yobitrust.Services.EmailSenderService;
import com.yobitrust.Services.UserDetailsImpl;
import com.yobitrust.payload.request.LoginRequest;
import com.yobitrust.payload.request.SignupRequest;
import com.yobitrust.payload.response.JwtResponse;
import com.yobitrust.payload.response.MessageResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class AuthetificationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {
		
		if (userRepository.findByEmailIgnoreCase(loginRequest.getEmail()).getIsEnabled() == false) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Please confirm your account!"));
		}
		
		
		else {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new JwtResponse(jwt,
													 userDetails.getId(), 
													 userDetails.getUsername(), 
													 userDetails.getEmail(), 
													 roles));
		}
		
	}
	@PostMapping("/update")
	public ResponseEntity<?> authenticateUser1( @RequestBody LoginRequest loginRequest) {
		User existingUser = userRepository.findByEmailIgnoreCase(loginRequest.getEmail());
		if (existingUser == null) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Please confirm your account!"));
		}


		else {
			existingUser.setPassword(encoder.encode(loginRequest.getPassword()));
			ConfirmationToken confirmationToken = new ConfirmationToken(existingUser);
			confirmationTokenRepository.save(confirmationToken);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(existingUser.getEmail());
			mailMessage.setSubject("Complete Registration!");
			mailMessage.setFrom("jakodg4@gmail.com");
			mailMessage.setText("To confirm your account, please enter this code : "
					+confirmationToken.getConfirmationToken());
			emailSenderService.sendEmail(mailMessage);
			userRepository.save(existingUser);
			return ResponseEntity.ok(new MessageResponse("Password registered successfully!"));
		}

	}
	
	@GetMapping(value="/confirm-account/{confirmationToken}")
    public ResponseEntity<?>  confirmUserAccount(@PathVariable("confirmationToken")String confirmationToken){
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            User user = userRepository.findByEmailIgnoreCase(token.getUser().getEmail());
            user.setEnable(true);
            userRepository.save(user);
            return ResponseEntity.ok(new MessageResponse("account Verified!"));

        }
        else
        {
        	
        	return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Link broken!"));
        }

        
    }	
		
	/* @PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		
		User existingUser = userRepository.findByEmailIgnoreCase(signUpRequest.getEmail());
        if(existingUser != null)
        {
        	return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
        }
	
        else {
        	// Create new user's account
    		User user = new User(signUpRequest.getUsername(),
    							 signUpRequest.getEmail(),
    							 encoder.encode(signUpRequest.getPassword()),
    							 signUpRequest.getGender(),
    							 signUpRequest.getLocation(),
    							 signUpRequest.getEnable());

    		Set<String> strRoles = signUpRequest.getRoles();
    		Set<Role> roles = new HashSet<>();

    		if (strRoles == null) {
    			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
    					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    			roles.add(userRole);
    		} else {
    			strRoles.forEach(role -> {
    				switch (role) {
    				case "admin":
    					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
    							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    					roles.add(adminRole);

    					break;
    				case "mod":
    					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
    							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    					roles.add(modRole);

    					break;
    				default:
    					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
    							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    					roles.add(userRole);
    				}
    			});
    		}

    		user.setRoles(roles);
    		userRepository.save(user);
    		
    		ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("jakodg4@gmail.com");
            mailMessage.setText("To confirm your account, please enter this code : "
            +confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);


    		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
		
		
	}*/
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
		
		User existingUser = userRepository.findByEmailIgnoreCase(signUpRequest.getEmail());
        if(existingUser != null)
        {
        	return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
        }

        else {
        	// Create new user's account
    		User user = new User( signUpRequest.getId(),
    							 signUpRequest.getUsername(),
    							 signUpRequest.getEmail(),
    							 encoder.encode(signUpRequest.getPassword()),
    							 signUpRequest.getGender(),
    							 signUpRequest.getLocation(),
    							 signUpRequest.getEnable()
    							
    							 );





    			ConfirmationToken confirmationToken = new ConfirmationToken(user);

                confirmationTokenRepository.save(confirmationToken);

                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(user.getEmail());
                mailMessage.setSubject("Complete Registration!");
                mailMessage.setFrom("jakodg4@gmail.com");
                mailMessage.setText("To confirm your account, please enter this code : "
                +confirmationToken.getConfirmationToken());

                emailSenderService.sendEmail(mailMessage);
                userRepository.save(user); 
               // clientRepository.save(client);
        		



    		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
		
		
	}
	
	@GetMapping("/doctors") 
	public ResponseEntity<List<Doctor>> getDoctors() {
		  List<Doctor> doctors = new ArrayList<Doctor>() ;
		  doctorRepository.findAll().forEach(doctors::add);
		  if (doctors.isEmpty()) {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    
		  } else {
			  return new ResponseEntity<>(doctors, HttpStatus.OK);
		  }
	}
	@GetMapping("/users") 
	public ResponseEntity<List<User>> getusers() {
		  List<User> doctors = new ArrayList<User>() ;
		  userRepository.findAll().forEach(doctors::add);
		  if (doctors.isEmpty()) {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    
		  } else {
			  return new ResponseEntity<>(doctors, HttpStatus.OK);
		  }
	}
	
	@GetMapping("/usersClients") 
	public ResponseEntity<List<Client>> getclients() {
		  List<Client> doctors = new ArrayList<Client>() ;
		  clientRepository.findAll().forEach(doctors::add);
		  if (doctors.isEmpty()) {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    
		  } else {
			  return new ResponseEntity<>(doctors, HttpStatus.OK);
		  }
	}
	
	/*@GetMapping("/users/{roles}") 
	public ResponseEntity<User> getusersbyrole(@PathVariable("roles")Set<Role> roles) {
		Optional<User> doctors = userRepository.findByRoles(roles);
		  if (doctors.isPresent()) {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    
		  } else {
			  return new ResponseEntity<>(doctors.get(), HttpStatus.OK);
		  }
	}*/
	
	
	@GetMapping("/doctorsNumber") 
	public int getDoctorsNumber() {
		  List<Doctor> doctors = new ArrayList<Doctor>();
		  doctorRepository.findAll().forEach(doctors::add);
		  int lenght = doctors.size();
		  return lenght;
		 
	}
	
	@GetMapping("/clientsNumber") 
	public int getClientsNumber() {
		  List<Client> doctors = new ArrayList<Client>();
		  clientRepository.findAll().forEach(doctors::add);
		  int lenght = doctors.size();
		  return lenght;
		 
	}
	
	
	@GetMapping("/users/doctors/{id}") 
	public String getDocterByuserId(@PathVariable("id") String id) {
		  
		Optional<User> user = userRepository.findById(id);
		Doctor doctor = doctorRepository.findByUser(user.get());
		  if (user.isEmpty()) {
			  return "No data found";
		    
		  } else {
			  
			  return doctor.getId();
		  }
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
	  try {
	    userRepository.deleteById(id);
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@DeleteMapping("/doctors/{idUser}")
	public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable("idUser") String idUser) {
	  try {
		  String id = getDocterByuserId(idUser);
		  doctorRepository.deleteById(id);
	   
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@GetMapping("/users/clients/{id}") 
	public String getClientsByuserId(@PathVariable("id") String id) {
		  
		Optional<User> user = userRepository.findById(id);
		Client client = clientRepository.findByUser(user.get());
		  if (user.isEmpty()) {
			  return "No data found";
		    
		  } else {
			  
			  return client.getId();
		  }
	}
	
	@DeleteMapping("/clients/{idUser}")
	public ResponseEntity<HttpStatus> deleteClient(@PathVariable("idUser") String idUser) {
	  try {
		  String id = getClientsByuserId(idUser);
		  clientRepository.deleteById(id);
	   
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
}
