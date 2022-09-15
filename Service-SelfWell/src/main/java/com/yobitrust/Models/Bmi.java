package com.yobitrust.Models;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@Document(collection = "bmi")
@Data 
@ToString
public class Bmi {
	
	@Id
	private String idBmi;
	private float weight;
	private float height;
	private float bmi;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date bmiDate;
	private String idUser;
	
	
	public String getIdBmi() {
		return idBmi;
	}
	public void setIdBmi(String id) {
		this.idBmi = id;
	}
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	
	public float getBmi() {
		return bmi;
	}
	public void setBmi(float bmi) {
		this.bmi = bmi;
	}
	
	public Date getBmiDate() {
		return bmiDate;
	}
	public void setBmiDate(Date bmiDate) {
		this.bmiDate = bmiDate;
	}
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	
	public Bmi() {
		super();
	}
	public Bmi(String idBmi, float weight, float height, float bmi, String idUser) {
		this.idBmi = idBmi;
		this.weight = weight;
		this.height = height;
		this.bmi = bmi;
		this.idUser = idUser;
	}
	public Bmi(float weight, float height, float bmi, Date bmiDate, String idUser) {
		this.weight = weight;
		this.height = height;
		this.bmi = bmi;
		this.bmiDate = bmiDate;
		this.idUser = idUser;
	}
		
		
}
