package com.yobitrust.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yobitrust.DAO.CardiacRepository;
import com.yobitrust.Models.Cardiac;
import com.yobitrust.Service.CardiacServiceImpl;

@RestController
@RequestMapping("/cardiac")
public class CardiacController {
	
	@Autowired
	private CardiacRepository cardiacRepository;
	
	@Autowired
	private CardiacServiceImpl cardiacServiceImpl;
	
	@PostMapping("/add")
    public Cardiac saveUser(@RequestBody Cardiac cardiac) {
        return cardiacServiceImpl.saveCardiac(cardiac);
    }
	
	@GetMapping("/{idUser}")
	public ResponseEntity<List<Cardiac>>  getCardiacByIdUser(@PathVariable(required = false) String idUser) {
		 try {
			    List<Cardiac> tutorials = new ArrayList<Cardiac>();

			    
			    cardiacRepository.findByIdUser(idUser).forEach(tutorials::add);

			    if (tutorials.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(tutorials, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCardiac(@PathVariable("id") String id) {
	  try {
		  cardiacRepository.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cardiac> updateBloodAnalysis(@PathVariable("id") String id, @RequestBody Cardiac cardiac) {
	  Optional<Cardiac> cardiacData = cardiacRepository.findById(id);

	  if (cardiacData.isPresent()) {
		  Cardiac _cardiac= cardiacData.get();
		  _cardiac.setSystolic(cardiac.getSystolic());
		  _cardiac.setDiastolic(cardiac.getDiastolic());
		  _cardiac.setHeartRate(cardiac.getHeartRate());
		  _cardiac.setCardiacDate(cardiac.getCardiacDate());
	    return new ResponseEntity<>(cardiacRepository.save(_cardiac), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}


}
