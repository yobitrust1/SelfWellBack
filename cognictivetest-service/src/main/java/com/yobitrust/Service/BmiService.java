package com.yobitrust.Service;

import com.yobitrust.Models.Bmi;

import java.util.Date;


public interface BmiService {
	public Bmi saveBmi(float weight, float height, float bmiValue, Date bmiDate, String idUser);
	
	//public ResponseTemplateVo sendRequest(String idBmi);	

}

