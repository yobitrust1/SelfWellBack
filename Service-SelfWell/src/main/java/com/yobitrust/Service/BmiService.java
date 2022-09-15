package com.yobitrust.Service;

import java.util.Date;

import org.springframework.http.HttpMethod;

import com.yobitrust.Models.Bmi;


public interface BmiService {
	public Bmi saveBmi(float weight, float height, float bmi, Date bmiDate, String idUser);
	
	//public ResponseTemplateVo sendRequest(String idBmi);	
}
