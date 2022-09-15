package com.yobitrust.payload.request;

import java.util.Date;
import java.util.Set;

import com.yobitrust.Models.User;

public class SignupRequest {
	
	    private String id;
	    private String username;

	    private String email;
	    
	    private Set<String> roles;
	    
	    private String password;
	    
	    private String location;
		  
		  private Date created; 
	    
	    private boolean enable;
	    
	    private String gender; 
	  
	    private User user;
	    
	    private int age;
	    
	    private String speciality;
	    
	    private String photo;
	    
	    private String phone;
	    
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
	    
	    public Set<String> getRoles() {
	      return this.roles;
	    }
	    
	    public void setRole(Set<String> roles) {
	      this.roles = roles;
	    }

	

		public boolean getEnable() {
			return enable;
		}

		public void setEnable(boolean enable) {
			this.enable = enable;
		}

		public void setRoles(Set<String> roles) {
			this.roles = roles;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public Date getCreated() {
			return created;
		}

		public void setCreated(Date created) {
			this.created = created;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getSpeciality() {
			return speciality;
		}

		public void setSpeciality(String speciality) {
			this.speciality = speciality;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
}
