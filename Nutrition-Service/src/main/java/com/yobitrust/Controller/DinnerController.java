package com.yobitrust.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yobitrust.DAO.DinnerRepository;
import com.yobitrust.Models.Dinner;



@RestController
@RequestMapping("/dinner")
public class DinnerController {
	
	@Autowired
	private DinnerRepository dinnerRepository;
	
	@PutMapping("/{id}/{dinnerDate}")
    public Dinner saveDinner(@PathVariable(required = false) String id, @PathVariable(required = false) String dinnerDate, @RequestBody Dinner dinner) {
		Optional<Dinner> dinnerData = dinnerRepository.findByIdUserAndDinnerDate(id, dinnerDate);
		if (dinnerData.isPresent()) {
			Dinner _dinner= dinnerData.get();
			_dinner.getFood().addAll(dinner.getFood());
			_dinner.setCalories(Float.toString(Float.parseFloat(_dinner.getCalories())+Float.parseFloat(dinner.getCalories())));
			_dinner.setCalcium(Float.toString(Float.parseFloat(_dinner.getCalcium())+Float.parseFloat(dinner.getCalcium())));
			_dinner.setFat(Float.toString(Float.parseFloat(_dinner.getFat())+Float.parseFloat(dinner.getFat())));
			_dinner.setFiber(Float.toString(Float.parseFloat(_dinner.getFiber())+Float.parseFloat(dinner.getFiber())));
			_dinner.setProtein(Float.toString(Float.parseFloat(_dinner.getProtein())+Float.parseFloat(dinner.getProtein())));
			_dinner.setSaturatedFats(Float.toString(Float.parseFloat(_dinner.getSaturatedFats())+Float.parseFloat(dinner.getSaturatedFats())));
			_dinner.setNetCarbs(Float.toString(Float.parseFloat(_dinner.getNetCarbs())+Float.parseFloat(dinner.getNetCarbs())));  
			  
		    return dinnerRepository.save(_dinner);
			
		}
		else {
			return dinnerRepository.save(dinner);
		}
		
    }
	
	@GetMapping("{idUser}/{dinnerDate}")
    public Optional<Dinner> getDinner(@PathVariable(required = false) String idUser, @PathVariable(required = false) String dinnerDate) {
		return  dinnerRepository.findByIdUserAndDinnerDate(idUser, dinnerDate);
	
    }
	
	@PutMapping("/deleteFood/{id}/{index}")
    public Dinner deleteFood(@PathVariable(required = false) String id, @PathVariable(required = false) int index, @RequestBody Dinner dinner) {
		Optional<Dinner> dinnerData = dinnerRepository.findById(id);
		
			Dinner _dinner= dinnerData.get();
			_dinner.getFood().remove(index);
			_dinner.setCalories(Float.toString(Float.parseFloat(_dinner.getCalories())-Float.parseFloat(dinner.getCalories())));
			_dinner.setCalcium(Float.toString(Float.parseFloat(_dinner.getCalcium())-Float.parseFloat(dinner.getCalcium())));
			_dinner.setFat(Float.toString(Float.parseFloat(_dinner.getFat())-Float.parseFloat(dinner.getFat())));
			_dinner.setFiber(Float.toString(Float.parseFloat(_dinner.getFiber())-Float.parseFloat(dinner.getFiber())));
			_dinner.setProtein(Float.toString(Float.parseFloat(_dinner.getProtein())-Float.parseFloat(dinner.getProtein())));
			_dinner.setSaturatedFats(Float.toString(Float.parseFloat(_dinner.getSaturatedFats())-Float.parseFloat(dinner.getSaturatedFats())));
			_dinner.setNetCarbs(Float.toString(Float.parseFloat(_dinner.getNetCarbs())-Float.parseFloat(dinner.getNetCarbs())));  
		      return dinnerRepository.save(_dinner);
			
		
    }
	
}
