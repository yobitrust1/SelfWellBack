package com.yobitrust.Service;

import com.yobitrust.DAO.BloodAnalyseRepository;
import com.yobitrust.Models.BloodAnalyse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class ExcelService {
	@Autowired
	BloodAnalyseRepository repository;

	  public ByteArrayInputStream load() {
	    List<BloodAnalyse> tutorials = repository.findAll();

	    ByteArrayInputStream in = BilanExcelExporter.tutorialsToExcel(tutorials);
	    
	    return in;
	  }
}
