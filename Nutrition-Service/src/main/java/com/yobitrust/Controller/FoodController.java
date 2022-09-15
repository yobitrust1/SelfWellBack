package com.yobitrust.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.yobitrust.DAO.FoodNameRepository;
import com.yobitrust.DAO.FoodnameRepository;
import com.yobitrust.Models.FoodName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yobitrust.DAO.FoodRepository;
import com.yobitrust.Models.Food;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	private FoodRepository     foodRepository;
	@Autowired
	private FoodNameRepository foodnameRepository;
	@PostMapping("/adda")
	public FoodName saveFooda(@RequestBody FoodName foodName) { return foodnameRepository.save(foodName); }
	@PostMapping("/add")
    public Food saveFood(@RequestBody Food food) {
        return foodRepository.save(food);
    }


	@GetMapping("/{id}") 
	public ResponseEntity<Food> getFoodById(@PathVariable("id") String id) {
		  Optional<Food> Food = foodRepository.findById(id);

		  if (Food.isPresent()) {
		    return new ResponseEntity<>(Food.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	}
	
	/*@GetMapping("/name/{name}") 
	public ResponseEntity<List<Food>> getFoodByName(@PathVariable("name") String name) {
		
		try {
		List<Food> foods = new ArrayList<Food>();

	    
	    foodRepository.findByNameContaining(name).forEach(foods::add);

	    if (foods.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(foods, HttpStatus.OK);
	  } catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	
	}*/
	@GetMapping("/tutorialsName")
	public ResponseEntity<List<FoodName>> getAllTutorialsNamea(
			@RequestParam(required = false) String name) {
		try {
			List<FoodName> tutorials = new ArrayList<FoodName>();
			//Pageable paging = PageRequest.of(page, size);
			if (name == null)
				foodnameRepository.findAll().forEach(tutorials::add);
			else
				foodnameRepository.findByNameContaining(name).forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/tutorials")
	public ResponseEntity<List<Food>> getAllTutorials(
			  @RequestParam(required = false) String name) {
	  try {
	    List<Food> tutorials = new ArrayList<Food>();
	    //Pageable paging = PageRequest.of(page, size);
	    if (name == null)
	      foodRepository.findAll().forEach(tutorials::add);
	    else
	    	foodRepository.findByNameContaining(name).forEach(tutorials::add);

	    if (tutorials.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(tutorials, HttpStatus.OK);
	  } catch (Exception e) {
	    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<Food> getFById(@PathVariable("id") String id) {
	  Optional<Food> food = foodRepository.findById(id);

	  if (food.isPresent()) {
	    return new ResponseEntity<>(food.get(), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
	@GetMapping("/byName/{name}")
	public ResponseEntity<Food> getFoodByName(@PathVariable("name") String name) {
	  Optional<Food> food = foodRepository.findByName(name);
	  if (food.isPresent()) {
	    return new ResponseEntity<>(food.get(), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
}
