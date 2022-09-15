package com.yobitrust.Models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "bloodAnalayse")
@Data 
@ToString
public class BloodAnalyse {
	
	@Id
	private String idBloodAnalyse;
	private String idUser;
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String bloodAnalysisDate;
	private float glucose;
	private float cReactiveProtein;
	private float dDimer;
	private float ip10;
	private float freeAlbumin;
	private float leptin;
	private float adiponectin;
	private float igf1;
	private float resistin;
	private float opn;
	private float orexinA;
	private float melatonin;
	private float creatinine;
	
	public String getIdBloodAnalyse() {
		return idBloodAnalyse;
	}
	public void setIdBloodAnalyse(String idBloodAnalyse) {
		this.idBloodAnalyse = idBloodAnalyse;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public float getGlucose() {
		return glucose;
	}
	public void setGlucose(float glucose) {
		this.glucose = glucose;
	}
	public float getcReactiveProtein() {
		return cReactiveProtein;
	}
	public void setcReactiveProtein(float cReactiveProtein) {
		this.cReactiveProtein = cReactiveProtein;
	}
	public float getdDimer() {
		return dDimer;
	}
	public void setdDimer(float dDimer) {
		this.dDimer = dDimer;
	}
	public float getIp10() {
		return ip10;
	}
	public void setIp10(float ip10) {
		this.ip10 = ip10;
	}
	public float getFreeAlbumin() {
		return freeAlbumin;
	}
	public void setFreeAlbumin(float freeAlbumin) {
		this.freeAlbumin = freeAlbumin;
	}
	public float getLeptin() {
		return leptin;
	}
	public void setLeptin(float leptin) {
		this.leptin = leptin;
	}
	public float getAdiponectin() {
		return adiponectin;
	}
	public void setAdiponectin(float adiponectin) {
		this.adiponectin = adiponectin;
	}
	public float getIgf1() {
		return igf1;
	}
	public void setIgf1(float igf1) {
		this.igf1 = igf1;
	}
	public float getResistin() {
		return resistin;
	}
	public void setResistin(float resistin) {
		this.resistin = resistin;
	}
	public float getOpn() {
		return opn;
	}
	public void setOpn(float opn) {
		this.opn = opn;
	}
	public float getOrexinA() {
		return orexinA;
	}
	public void setOrexinA(float orexinA) {
		this.orexinA = orexinA;
	}
	public float getMelatonin() {
		return melatonin;
	}
	public void setMelatonin(float melatonin) {
		this.melatonin = melatonin;
	}
	public float getCreatinine() {
		return creatinine;
	}
	public void setCreatinine(float creatinine) {
		this.creatinine = creatinine;
	}
	
	public BloodAnalyse() {
		
	}
	public BloodAnalyse(String idUser, float glucose, float cReactiveProtein, float dDimer, float ip10, float freeAlbumin,
			float leptin, float adiponectin, float igf1, float resistin, float opn, float orexinA, float melatonin, float creatinine) {
		super();
		this.idUser = idUser;
		this.glucose = glucose;
		this.cReactiveProtein = cReactiveProtein;
		this.dDimer = dDimer;
		this.ip10 = ip10;
		this.freeAlbumin = freeAlbumin;
		this.leptin = leptin;
		this.adiponectin = adiponectin;
		this.igf1 = igf1;
		this.resistin = resistin;
		this.opn = opn;
		this.orexinA = orexinA;
		this.melatonin = melatonin;
		this.creatinine = creatinine;
	}
	public String getBloodAnalysisDate() {
		return bloodAnalysisDate;
	}
	public void setBloodAnalysisDate(String bloodAnalysisDate) {
		this.bloodAnalysisDate = bloodAnalysisDate;
	}
	public BloodAnalyse(String idUser, String bloodAnalysisDate, float glucose, float cReactiveProtein, float dDimer,
			float ip10, float freeAlbumin, float leptin, float adiponectin, float igf1, float resistin, float opn,
			float orexinA, float melatonin, float creatinine) {
		super();
		this.idUser = idUser;
		this.bloodAnalysisDate = bloodAnalysisDate;
		this.glucose = glucose;
		this.cReactiveProtein = cReactiveProtein;
		this.dDimer = dDimer;
		this.ip10 = ip10;
		this.freeAlbumin = freeAlbumin;
		this.leptin = leptin;
		this.adiponectin = adiponectin;
		this.igf1 = igf1;
		this.resistin = resistin;
		this.opn = opn;
		this.orexinA = orexinA;
		this.melatonin = melatonin;
		this.creatinine = creatinine;
	}
	
	

}
