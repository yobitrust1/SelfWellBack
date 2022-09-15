package com.yobitrust.Models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;



@Document(collection = "users")
@Data 
@ToString
public class User {

	  @Id
	  private String id;
	
	  private String username;

	  private String email;

	  private String password;
	  
	  private String gender;
	  
	  private String location;
	  
	  private boolean isEnabled;

	  @DBRef
	  private Set<Role> roles = new HashSet<>();

	  public User() {
	  }

	  public User(String username, String email, String password) {
	    this.username = username;
	    this.email = email;
	    this.password = password;
	  }

	  

	 public User(String username,String email,
			String password, String gender, String location, boolean isEnabled) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.location = location;
		this.isEnabled = isEnabled;
		
	}
	 
	 

	public User(String username, String email, String password, String gender, String location, boolean isEnabled,
			Set<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.location = location;
		this.isEnabled = isEnabled;
		this.roles = roles;
	}

	public User(String id, String username, String email, String password, String gender, String location, boolean isEnabled
			) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.location = location;
		this.isEnabled = isEnabled;
		
	}

	public String getId() {
	    return id;
	  }

	  public void setId(String id) {
	    this.id = id;
	  }

	  public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	  
	  public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public boolean getIsEnabled() {
		return isEnabled;
	}

	public void setEnable(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Set<Role> getRoles() {
	    return roles;
	  }

	  public void setRoles(Set<Role> roles) {
	    this.roles = roles;
	  }

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	
}