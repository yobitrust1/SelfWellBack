package com.yobitrust.VO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data 
@ToString 
public class AppUser {
	
	private String idUser;
	private String fullName;
	private String email;
	private String password;
	private String gender;
	private Date birthDate;
	
	
	public AppUser() {
		
	}
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String userName) {
		this.fullName = userName;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public AppUser(String idUser, String fullName, String email, String password, String gender, Date birthDate) {
		super();
		this.idUser = idUser;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public AppUser(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public AppUser(String fullName, String email, String password, String gender, Date birthDate) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	
	
}
