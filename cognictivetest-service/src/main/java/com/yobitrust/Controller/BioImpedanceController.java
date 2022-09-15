package com.yobitrust.Controller;

import com.yobitrust.DAO.BioImpedanceRepository;
import com.yobitrust.Models.BioImpedance;
import com.yobitrust.Service.BioImpedanceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bioImpedance")
public class BioImpedanceController {
	

	@Autowired
	private BioImpedanceRepository bioImpedanceRepository;
	
	@Autowired
	private BioImpedanceImpl bioImpedanceImpl;
	
	@PostMapping("/add")
    public BioImpedance saveUser(@RequestBody BioImpedance bioImpedance) {
        return bioImpedanceImpl.saveBioImpedance(bioImpedance);
    }
	
	@GetMapping("/{idUser}")
	public ResponseEntity<List<BioImpedance>>  getBioImpedanceByIdUser(@PathVariable(required = false) String idUser) {
		 try {
			    List<BioImpedance> tutorials = new ArrayList<BioImpedance>();

			    
			    bioImpedanceRepository.findByIdUser(idUser).forEach(tutorials::add);

			    if (tutorials.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(tutorials, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteidBloodAnalysis(@PathVariable("id") String id) {
	  try {
	    bioImpedanceRepository.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BioImpedance> updateBloodAnalysis(@PathVariable("id") String id, @RequestBody BioImpedance bioImpedance) {
	  Optional<BioImpedance> bioImpedanceData = bioImpedanceRepository.findById(id);

	  if (bioImpedanceData.isPresent()) {
		  BioImpedance _bioImpedance= bioImpedanceData.get();
		  _bioImpedance.setBioImpedanceValue(bioImpedance.getBioImpedanceValue());
		  _bioImpedance.setBioImpedanceDate(bioImpedance.getBioImpedanceDate());
		  
	    return new ResponseEntity<>(bioImpedanceRepository.save(_bioImpedance), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}


}
