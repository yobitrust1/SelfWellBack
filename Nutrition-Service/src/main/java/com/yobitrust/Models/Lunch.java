package com.yobitrust.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "lunch")
@Data 
@NoArgsConstructor
@ToString
public class Lunch {

	@Id
	private String id;
	private String idUser;
	private String lunchDate;
	private List<Food> Food;
	private String calories;
	private String fat;
	private String protein;
	private String fiber;
	private String saturatedFats;
	private String calcium;
	private String netCarbs;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	public List<Food> getFood() {
		return Food;
	}
	public void setFood(List<Food> food) {
		Food = food;
	}
	public String getCalories() {
		return calories;
	}
	public void setCalories(String calories) {
		this.calories = calories;
	}
	public String getFat() {
		return fat;
	}
	public void setFat(String fat) {
		this.fat = fat;
	}
	public String getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
		this.protein = protein;
	}
	public String getFiber() {
		return fiber;
	}
	public void setFiber(String fiber) {
		this.fiber = fiber;
	}
	public String getSaturatedFats() {
		return saturatedFats;
	}
	public void setSaturatedFats(String saturatedFats) {
		this.saturatedFats = saturatedFats;
	}
	public String getCalcium() {
		return calcium;
	}
	public void setCalcium(String calcium) {
		this.calcium = calcium;
	}
	public String getLunchDate() {
		return lunchDate;
	}
	public void setLunchDate(String lunchDate) {
		this.lunchDate = lunchDate;
	}
	public String getNetCarbs() {
		return netCarbs;
	}
	public void setNetCarbs(String netCarbs) {
		this.netCarbs = netCarbs;
	}
	
	
}
