package com.yobitrust.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "cardiac")
@Data 
@ToString
public class Cardiac {

	@Id
	private String idCardiac;
	private String idUser;
	private float systolic;
	private float diastolic;
	private float heartRate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date cardiacDate;
	
	public String getIdCardiac() {
		return idCardiac;
	}
	public void setIdCardiac(String idCardiac) {
		this.idCardiac = idCardiac;
	}
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	public float getSystolic() {
		return systolic;
	}
	public void setSystolic(float systolic) {
		this.systolic = systolic;
	}
	
	public float getDiastolic() {
		return diastolic;
	}
	public void setDiastolic(float diastolic) {
		this.diastolic = diastolic;
	}
	
	public float getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(float heartRate) {
		this.heartRate = heartRate;
	}
	
	
	public Date getCardiacDate() {
		return cardiacDate;
	}
	public void setCardiacDate(Date cardiacDate) {
		this.cardiacDate = cardiacDate;
	}
	
	public Cardiac(String idUser, float systolic, float diastolic, float heartRate, Date cardiacDate) {
		super();
		this.idUser = idUser;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.heartRate = heartRate;
		this.cardiacDate = cardiacDate;
	}
		
}
