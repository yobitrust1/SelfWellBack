package com.yobitrust.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yobitrust.DAO.BloodAnalyseRepository;
import com.yobitrust.Models.BloodAnalyse;
import com.yobitrust.Service.BilanExcelExporter;
import com.yobitrust.Service.BloodAnalyseServiceImpl;
import com.yobitrust.Service.EmailSenderService;
import com.yobitrust.Service.ExcelService;

@RestController
@RequestMapping("/bloodAnalyses")
public class BloodAnalyseController {

	private static final String DIRECTORY = "home/arij";
    private static final String DEFAULT_FILE_NAME = "tutorials.xlsx";
	 @Autowired
	 private BloodAnalyseServiceImpl bloodAnalyseServiceImpl;
	 
	 @Autowired
	 private BloodAnalyseRepository bloodAnalyseRepository;
	 
	 @Autowired
	EmailSenderService emailSenderService;
	 
	@PostMapping("/add")
    public BloodAnalyse saveUser(@RequestBody BloodAnalyse bloodAnalyse) {
        return bloodAnalyseServiceImpl.saveBloodAnalyse(bloodAnalyse);
    }
	
	@GetMapping("/{idUser}")
	public ResponseEntity<List<BloodAnalyse>>  getBloodAnalyseByIdUser(@PathVariable(required = false) String idUser) {
		 try {
			    List<BloodAnalyse> tutorials = new ArrayList<BloodAnalyse>();

			    
			    bloodAnalyseRepository.findByIdUser(idUser).forEach(tutorials::add);

			    if (tutorials.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }

			    return new ResponseEntity<>(tutorials, HttpStatus.OK);
			  } catch (Exception e) {
			    return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<BloodAnalyse> getTutorialById(@PathVariable("id") String id) {
	  Optional<BloodAnalyse> bloodAnalysis = bloodAnalyseRepository.findById(id);

	  if (bloodAnalysis.isPresent()) {
	    return new ResponseEntity<>(bloodAnalysis.get(), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
	
	@DeleteMapping("/{idBloodAnalysis}")
	public ResponseEntity<HttpStatus> deleteidBloodAnalysis(@PathVariable("idBloodAnalysis") String idBloodAnalysis) {
	  try {
	    bloodAnalyseRepository.deleteById(idBloodAnalysis);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
	@PutMapping("/{idBloodAnalysis}")
	public ResponseEntity<BloodAnalyse> updateBloodAnalysis(@PathVariable("idBloodAnalysis") String idBloodAnalysis, @RequestBody BloodAnalyse bloodAnalysis) {
	  Optional<BloodAnalyse> bloodAnalysisData = bloodAnalyseRepository.findById(idBloodAnalysis);

	  if (bloodAnalysisData.isPresent()) {
		  BloodAnalyse _bloodAnalyse= bloodAnalysisData.get();
		  _bloodAnalyse.setGlucose(bloodAnalysis.getGlucose());
		  _bloodAnalyse.setAdiponectin(bloodAnalysis.getAdiponectin());
		  _bloodAnalyse.setcReactiveProtein(bloodAnalysis.getcReactiveProtein());;
		  _bloodAnalyse.setCreatinine(bloodAnalysis.getCreatinine());
		  _bloodAnalyse.setdDimer(bloodAnalysis.getdDimer());
		  _bloodAnalyse.setFreeAlbumin(bloodAnalysis.getFreeAlbumin());
		  _bloodAnalyse.setIgf1(bloodAnalysis.getIgf1());
		  _bloodAnalyse.setIp10(bloodAnalysis.getIp10());
		  _bloodAnalyse.setLeptin(bloodAnalysis.getLeptin());
		  _bloodAnalyse.setMelatonin(bloodAnalysis.getMelatonin());
		  _bloodAnalyse.setOpn(bloodAnalysis.getOpn());
		  _bloodAnalyse.setOrexinA(bloodAnalysis.getOrexinA());
		  _bloodAnalyse.setResistin(bloodAnalysis.getResistin());
		  
	    return new ResponseEntity<>(bloodAnalyseRepository.save(_bloodAnalyse), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}

	@PutMapping("{idUser}/{bloodAnalysisDate}")
    public BloodAnalyse saveBreakfast(@PathVariable  String idUser, @PathVariable  String bloodAnalysisDate, @RequestBody BloodAnalyse breakfast) {
		Optional<BloodAnalyse> breakfastData = bloodAnalyseRepository.findByIdUserAndBloodAnalysisDate(idUser, bloodAnalysisDate);
		if (breakfastData.isPresent()) {
			BloodAnalyse _breakfast= breakfastData.get();
			if (breakfast.getGlucose() > 0) {
				_breakfast.setGlucose(breakfast.getGlucose());
			}
			if (breakfast.getAdiponectin() > 0) {
				_breakfast.setAdiponectin(breakfast.getAdiponectin());
			}
			if (breakfast.getcReactiveProtein() > 0) {
				_breakfast.setcReactiveProtein(breakfast.getcReactiveProtein());
			}
			if (breakfast.getCreatinine() > 0) {
				_breakfast.setCreatinine(breakfast.getCreatinine());
			}
			if (breakfast.getdDimer() > 0) {
				_breakfast.setdDimer(breakfast.getdDimer());
			}
			if (breakfast.getFreeAlbumin() > 0) {
				_breakfast.setFreeAlbumin(breakfast.getFreeAlbumin());
			}
			if (breakfast.getIgf1() > 0) {
				_breakfast.setIgf1(breakfast.getIgf1());
			}
			if (breakfast.getIp10() > 0) {
				_breakfast.setIp10(breakfast.getIp10());
			}
			if (breakfast.getLeptin() > 0) {
				_breakfast.setLeptin(breakfast.getLeptin());
			}
			if (breakfast.getMelatonin() > 0) {
				_breakfast.setMelatonin(breakfast.getMelatonin());
			}
			  
			if (breakfast.getOpn() > 0) {
				_breakfast.setOpn(breakfast.getOpn());
			}
			if (breakfast.getOrexinA() > 0) {
				_breakfast.setOrexinA(breakfast.getOrexinA());
			}
			if (breakfast.getResistin() > 0) {
				_breakfast.setResistin(breakfast.getResistin());
			}  
			  
		    return bloodAnalyseRepository.save(_breakfast);
			
		}
		else {
			return bloodAnalyseRepository.save(breakfast);
		}
		
    }
	
	@GetMapping("{idUser}/{bloodAnalysisDate}")
	public ResponseEntity<BloodAnalyse> getexisted(@PathVariable String idUser, @PathVariable String bloodAnalysisDate) {
		Optional<BloodAnalyse> bloodAnalysis = bloodAnalyseRepository.findByIdUserAndBloodAnalysisDate(idUser, bloodAnalysisDate);
	  if (bloodAnalysis.isPresent()) {
	    return new ResponseEntity<>(bloodAnalysis.get(), HttpStatus.OK);
	  } else {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	}
	
	@GetMapping("/getByidUser/{idUser}")
	public ResponseEntity<List<BloodAnalyse>> getGlucose(@PathVariable String idUser) {
		try {
		    List<BloodAnalyse> blood = new ArrayList<BloodAnalyse>();
	
		    bloodAnalyseRepository.findByIdUser(idUser).forEach(blood::add);
		    
		    if (blood.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    return new ResponseEntity<>(blood, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
		 

}
