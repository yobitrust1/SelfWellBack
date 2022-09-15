package com.yobitrust.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yobitrust.DAO.LunchRepository;
import com.yobitrust.Models.Lunch;


@RestController
@RequestMapping("/lunch")
public class LunchController {

	@Autowired
	private LunchRepository lunchRepository;
	
	@PutMapping("/{id}/{lunchDate}")
    public Lunch saveLunch(@PathVariable(required = false) String id, @PathVariable(required = false) String lunchDate, @RequestBody Lunch lunch) {
		Optional<Lunch> lunchData = lunchRepository.findByIdUserAndLunchDate(id, lunchDate);
		if (lunchData.isPresent()) {
			Lunch _lunch= lunchData.get();
			_lunch.getFood().addAll(lunch.getFood());
			_lunch.setCalories(Float.toString(Float.parseFloat(_lunch.getCalories())+Float.parseFloat(lunch.getCalories())));
			_lunch.setCalcium(Float.toString(Float.parseFloat(_lunch.getCalcium())+Float.parseFloat(lunch.getCalcium())));
			_lunch.setFat(Float.toString(Float.parseFloat(_lunch.getFat())+Float.parseFloat(lunch.getFat())));
			_lunch.setFiber(Float.toString(Float.parseFloat(_lunch.getFiber())+Float.parseFloat(lunch.getFiber())));
			_lunch.setProtein(Float.toString(Float.parseFloat(_lunch.getProtein())+Float.parseFloat(lunch.getProtein())));
			_lunch.setSaturatedFats(Float.toString(Float.parseFloat(_lunch.getSaturatedFats())+Float.parseFloat(lunch.getSaturatedFats())));
			_lunch.setNetCarbs(Float.toString(Float.parseFloat(_lunch.getNetCarbs())+Float.parseFloat(lunch.getNetCarbs())));  
			  
		    return lunchRepository.save(_lunch);
			
		}
		else {
			return lunchRepository.save(lunch);
		}
		
    }
	
	@GetMapping("{idUser}/{lunchDate}")
    public Optional<Lunch> getLunch(@PathVariable(required = false) String idUser, @PathVariable(required = false) String lunchDate) {
		return  lunchRepository.findByIdUserAndLunchDate(idUser, lunchDate);
	
    }
	
	@PutMapping("/deleteFood/{id}/{index}")
    public Lunch deleteFood(@PathVariable(required = false) String id, @PathVariable(required = false) int index, @RequestBody Lunch lunch) {
		Optional<Lunch> dinnerData = lunchRepository.findById(id);
		
			Lunch _lunch= dinnerData.get();
			if (_lunch.getFood().isEmpty()) {
				lunchRepository.deleteById(id);
				return lunch;
			}
			else {
			_lunch.getFood().remove(index);
			_lunch.setCalories(Float.toString(Float.parseFloat(_lunch.getCalories())-Float.parseFloat(lunch.getCalories())));
			_lunch.setCalcium(Float.toString(Float.parseFloat(_lunch.getCalcium())-Float.parseFloat(lunch.getCalcium())));
			_lunch.setFat(Float.toString(Float.parseFloat(_lunch.getFat())-Float.parseFloat(lunch.getFat())));
			_lunch.setFiber(Float.toString(Float.parseFloat(_lunch.getFiber())-Float.parseFloat(lunch.getFiber())));
			_lunch.setProtein(Float.toString(Float.parseFloat(_lunch.getProtein())-Float.parseFloat(lunch.getProtein())));
			_lunch.setSaturatedFats(Float.toString(Float.parseFloat(_lunch.getSaturatedFats())-Float.parseFloat(lunch.getSaturatedFats())));
			_lunch.setNetCarbs(Float.toString(Float.parseFloat(_lunch.getNetCarbs())-Float.parseFloat(lunch.getNetCarbs())));  
		      return lunchRepository.save(_lunch);
			}
		
    }
	
}
