package com.yobitrust.Models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@Document(collection = "bioImpedance")
@Data 
@ToString
public class BioImpedance {
	
	@Id
	private String idBioImpedance;
	private String idUser;
	private float bioImpedanceValue;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date bioImpedanceDate;
	
	public String getIdBioImpedance() {
		return idBioImpedance;
	}
	public void setIdBioImpedance(String idBioImpedance) {
		this.idBioImpedance = idBioImpedance;
	}
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	public float getBioImpedanceValue() {
		return bioImpedanceValue;
	}
	public void setBioImpedanceValue(float bioImpedanceValue) {
		this.bioImpedanceValue = bioImpedanceValue;
	}
	
	public Date getBioImpedanceDate() {
		return bioImpedanceDate;
	}
	public void setBioImpedanceDate(Date bioImpedanceDate) {
		this.bioImpedanceDate = bioImpedanceDate;
	}
	
	
	public BioImpedance(String idUser, float bioImpedanceValue, Date bioImpedanceDate) {
		super();
		this.idUser = idUser;
		this.bioImpedanceValue = bioImpedanceValue;
		this.bioImpedanceDate = bioImpedanceDate;
	} 
	
	

}
