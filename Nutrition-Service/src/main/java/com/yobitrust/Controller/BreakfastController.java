package com.yobitrust.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yobitrust.DAO.BreakfastRepository;
import com.yobitrust.Models.Breakfast;

@RestController
@RequestMapping("/breakfast")
public class BreakfastController {

	@Autowired
	private BreakfastRepository breakfastRepository;
	
	@PutMapping("{id}/{breakfastDate}")
    public Breakfast saveBreakfast(@PathVariable(required = false) String id, @PathVariable(required = false) String breakfastDate, @RequestBody Breakfast breakfast) {
		Optional<Breakfast> breakfastData = breakfastRepository.findByIdUserAndBreakfastDate(id, breakfastDate);
		if (breakfastData.isPresent()) {
			Breakfast _breakfast= breakfastData.get();
			  _breakfast.getFood().addAll(breakfast.getFood());
			  _breakfast.setCalories(Float.toString(Float.parseFloat(_breakfast.getCalories())+Float.parseFloat(breakfast.getCalories())));
			  _breakfast.setCalcium(Float.toString(Float.parseFloat(_breakfast.getCalcium())+Float.parseFloat(breakfast.getCalcium())));
			  _breakfast.setFat(Float.toString(Float.parseFloat(_breakfast.getFat())+Float.parseFloat(breakfast.getFat())));
			  _breakfast.setFiber(Float.toString(Float.parseFloat(_breakfast.getFiber())+Float.parseFloat(breakfast.getFiber())));
			  _breakfast.setProtein(Float.toString(Float.parseFloat(_breakfast.getProtein())+Float.parseFloat(breakfast.getProtein())));
			  _breakfast.setSaturatedFats(Float.toString(Float.parseFloat(_breakfast.getSaturatedFats())+Float.parseFloat(breakfast.getSaturatedFats())));
			  _breakfast.setNetCarbs(Float.toString(Float.parseFloat(_breakfast.getNetCarbs())+Float.parseFloat(breakfast.getNetCarbs())));  
			  
		    return breakfastRepository.save(_breakfast);
			
		}
		else {
			return breakfastRepository.save(breakfast);
		}
		
    }
	
	@PutMapping("/deleteFood/{id}/{index}")
    public Breakfast deleteFood(@PathVariable(required = false) String id, @PathVariable(required = false) int index, @RequestBody Breakfast breakfast) {
		Optional<Breakfast> breakfastData = breakfastRepository.findById(id);
		
			Breakfast _breakfast= breakfastData.get();
			  _breakfast.getFood().remove(index);
			  _breakfast.setCalories(Float.toString(Float.parseFloat(_breakfast.getCalories())-Float.parseFloat(breakfast.getCalories())));
			  _breakfast.setCalcium(Float.toString(Float.parseFloat(_breakfast.getCalcium())-Float.parseFloat(breakfast.getCalcium())));
			  _breakfast.setFat(Float.toString(Float.parseFloat(_breakfast.getFat())-Float.parseFloat(breakfast.getFat())));
			  _breakfast.setFiber(Float.toString(Float.parseFloat(_breakfast.getFiber())-Float.parseFloat(breakfast.getFiber())));
			  _breakfast.setProtein(Float.toString(Float.parseFloat(_breakfast.getProtein())-Float.parseFloat(breakfast.getProtein())));
			  _breakfast.setSaturatedFats(Float.toString(Float.parseFloat(_breakfast.getSaturatedFats())-Float.parseFloat(breakfast.getSaturatedFats())));
			  _breakfast.setNetCarbs(Float.toString(Float.parseFloat(_breakfast.getNetCarbs())-Float.parseFloat(breakfast.getNetCarbs())));  
		      return breakfastRepository.save(_breakfast);
			
		
    }
	
	@GetMapping("{idUser}/{breakfastDate}")
    public Optional<Breakfast> getBreakfast(@PathVariable(required = false) String idUser, @PathVariable(required = false) String breakfastDate) {
		return  breakfastRepository.findByIdUserAndBreakfastDate(idUser, breakfastDate);
	
    }
	
	@GetMapping("{id}")
    public Optional<Breakfast> getBreakfastById(@PathVariable(required = false) String id) {
		return  breakfastRepository.findById(id);
	
    }
	
}
