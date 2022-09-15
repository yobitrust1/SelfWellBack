package com.yobitrust.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "doctor")
@Data 
@NoArgsConstructor
@ToString
public class Doctor {
	
	@Id
	private String id;
	private User user;
	private String speciality;
	private String photo;
	private String phone;
	private List<Client> clients;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Doctor(User user, String speciality, String photo, String phone) {
		super();
		this.user = user;
		this.speciality = speciality;
		this.photo = photo;
		this.phone = phone;
	}
	
	

}