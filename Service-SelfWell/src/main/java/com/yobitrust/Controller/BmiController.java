package com.yobitrust.Controller;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yobitrust.DAO.BmiRepository;
import com.yobitrust.Models.BloodAnalyse;
import com.yobitrust.Models.Bmi;
import com.yobitrust.Service.BmiService;

import lombok.Data;

@RestController
@RequestMapping("/bmi")
public class BmiController {
	
	Bmi bmi = new Bmi();
	
	@Autowired
	private BmiService bmiService;
	
	@Autowired
	private BmiRepository bmiRepository;
	
	@PostMapping("/add")
	public Bmi register(@RequestBody BmiForm bmiForm) {
		return bmiService.saveBmi(bmiForm.getWeight(), bmiForm.getHeight(), bmiForm.getBmi(), bmiForm.getBmiDate(), bmiForm.getIdUser());
	}
	
	@GetMapping("/bmilatest/{idUser}") 
	public ResponseEntity<Bmi> getBmiByLatestDate(@PathVariable("idUser") String idUser) {
		  Optional<Bmi> Bmi = bmiRepository.findFirstByIdUserOrderByBmiDateDesc(idUser);

		  if (Bmi.isPresent()) {
		    return new ResponseEntity<>(Bmi.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	}
	
	@GetMapping("/{idUser}")
	public ResponseEntity<List<Bmi>>  getBmiById(@PathVariable(required = false) String idUser) {
		 try {
			    List<Bmi> tutorials = new ArrayList<Bmi>();

			    
			    	bmiRepository.findByIdUser(idUser).forEach(tutorials::add);

			    if (tutorials.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(tutorials, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
			}
	
	@DeleteMapping("/{idBmi}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("idBmi") String idBmi) {
	  try {
	    bmiRepository.deleteById(idBmi);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@PutMapping("/{idBmi}")
	public ResponseEntity<Bmi> updateTutorial(@PathVariable("idBmi") String idBmi, @RequestBody Bmi bmi) {
	  Optional<Bmi> tutorialData = bmiRepository.findById(idBmi);

	  if (tutorialData.isPresent()) {
		 Bmi _bmi = tutorialData.get();
	    _bmi.setWeight(bmi.getWeight());
	    _bmi.setHeight(bmi.getHeight());
	    _bmi.setBmiDate(bmi.getBmiDate());
	    _bmi.setBmi(bmi.getBmi());
	    return new ResponseEntity<>(bmiRepository.save(_bmi), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}

	@PutMapping("up/{idUser}")
    public void saveBmiByDate(@PathVariable  String idUser, @RequestBody Bmi breakfast) {
		 		
				Optional<Bmi> tutorialData = bmiRepository.findByIdUserAndBmiDate(idUser, breakfast.getBmiDate());
				if (tutorialData.isPresent()) {
					Bmi _bmii = tutorialData.get();
					_bmii.setWeight(breakfast.getWeight());
					_bmii.setHeight(breakfast.getHeight());
					_bmii.setBmi(breakfast.getBmi());
				     bmiRepository.save(_bmii);
					System.out.println(_bmii.getBmiDate());
					System.out.println(breakfast.getBmiDate());
				}
				else {
					 bmiRepository.save(breakfast);
						System.out.println(breakfast.getBmiDate()+"bbbbbb");
				}
		 
    }
	

}

@Data
class BmiForm{
	private float weight;
	private float height;
	private float bmi;
	private Date bmiDate;
	private String idUser;
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getBmi() {
		return bmi;
	}
	public void setBmi(float bmi) {
		this.bmi = bmi;
	}
	public Date getBmiDate() {
		return bmiDate;
	}
	public void setBmiDate(Date bmiDate) {
		this.bmiDate = bmiDate;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
}
