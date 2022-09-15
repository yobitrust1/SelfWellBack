package com.yobitrust.Service;

import com.yobitrust.DAO.BloodAnalyseRepository;
import com.yobitrust.Models.BloodAnalyse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BloodAnalyseServiceImpl implements BloodAnalyseService{
	
	@Autowired
    private BloodAnalyseRepository bloodAnalyseRepository;

	@Override
	public BloodAnalyse saveBloodAnalyse(BloodAnalyse bloodAnalyse) {
		
		return bloodAnalyseRepository.save(bloodAnalyse);
	}

}
