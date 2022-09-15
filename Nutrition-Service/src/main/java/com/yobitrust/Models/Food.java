package com.yobitrust.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Document(collection = "food")
@Data 
@ToString
public class Food {

	@Id
	private String id;
	private String name;
	private String foodGroup;
	private String calories;
	private String fat;
	private String protein;
	private String carbohydrate;
	private String sugars;
	private String fiber;
	private String cholesterol;
	private String saturatedFats;
	private String calcium;
	private String ironFe;
	private String potassium;
	private String magnesium;
	private String vitaminC;
	private String netCarbs;
	private String water;
	private String sucrose;
	private String glucose;
	private String fructose;
	private String lactose;
	private String sodium;
	private String zinc;
	private String servingDescription;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFoodGroup() {
		return foodGroup;
	}
	public void setFoodGroup(String foodGroup) {
		this.foodGroup = foodGroup;
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
	public String getCarbohydrate() {
		return carbohydrate;
	}
	public void setCarbohydrate(String carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	public String getSugars() {
		return sugars;
	}
	public void setSugars(String sugars) {
		this.sugars = sugars;
	}
	public String getFiber() {
		return fiber;
	}
	public void setFiber(String fiber) {
		this.fiber = fiber;
	}
	public String getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(String cholesterol) {
		this.cholesterol = cholesterol;
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
	public String getIronFe() {
		return ironFe;
	}
	public void setIronFe(String ironFe) {
		this.ironFe = ironFe;
	}
	public String getPotassium() {
		return potassium;
	}
	public void setPotassium(String potassium) {
		this.potassium = potassium;
	}
	public String getMagnesium() {
		return magnesium;
	}
	public void setMagnesium(String magnesium) {
		this.magnesium = magnesium;
	}
	public String getVitaminC() {
		return vitaminC;
	}
	public void setVitaminC(String vitaminC) {
		this.vitaminC = vitaminC;
	}
	public String getNetCarbs() {
		return netCarbs;
	}
	public void setNetCarbs(String netCarbs) {
		this.netCarbs = netCarbs;
	}
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	public String getSucrose() {
		return sucrose;
	}
	public void setSucrose(String sucrose) {
		this.sucrose = sucrose;
	}
	public String getGlucose() {
		return glucose;
	}
	public void setGlucose(String glucose) {
		this.glucose = glucose;
	}
	public String getFructose() {
		return fructose;
	}
	public void setFructose(String fructose) {
		this.fructose = fructose;
	}
	public String getLactose() {
		return lactose;
	}
	public void setLactose(String lactose) {
		this.lactose = lactose;
	}
	public String getSodium() {
		return sodium;
	}
	public void setSodium(String sodium) {
		this.sodium = sodium;
	}
	public String getZinc() {
		return zinc;
	}
	public void setZinc(String zinc) {
		this.zinc = zinc;
	}
	public String getServingDescription() {
		return servingDescription;
	}
	public void setServingDescription(String servingDescription) {
		this.servingDescription = servingDescription;
	}
	public Food(String name, String foodGroup, String calories, String fat, String protein, String carbohydrate,
			String sugars, String fiber, String cholesterol, String saturatedFats, String calcium, String ironFe,
			String potassium, String magnesium, String vitaminC, String netCarbs, String water, String sucrose,
			String glucose, String fructose, String lactose, String sodium, String zinc, String servingDescription) {
		super();
		this.name = name;
		this.foodGroup = foodGroup;
		this.calories = calories;
		this.fat = fat;
		this.protein = protein;
		this.carbohydrate = carbohydrate;
		this.sugars = sugars;
		this.fiber = fiber;
		this.cholesterol = cholesterol;
		this.saturatedFats = saturatedFats;
		this.calcium = calcium;
		this.ironFe = ironFe;
		this.potassium = potassium;
		this.magnesium = magnesium;
		this.vitaminC = vitaminC;
		this.netCarbs = netCarbs;
		this.water = water;
		this.sucrose = sucrose;
		this.glucose = glucose;
		this.fructose = fructose;
		this.lactose = lactose;
		this.sodium = sodium;
		this.zinc = zinc;
		this.servingDescription = servingDescription;
	}
	
	
	
}
