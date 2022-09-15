package com.yobitrust.Service;

import com.yobitrust.DAO.BmiRepository;
import com.yobitrust.Models.Bmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class BmiServiceImpl implements BmiService {

	@Autowired
	private BmiRepository bmiRepository;

	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
	@Override
	public Bmi saveBmi(float weight, float height, float bmiValue, Date bmiDate, String idUser) {

		Bmi bmi = new Bmi( weight,  height,  bmiValue,  bmiDate,  idUser);
		bmi.setWeight(weight);
		bmi.setHeight(height);
		bmi.setBmi(bmiValue);
		bmi.setBmiDate(bmiDate);
		bmi.setIdUser(idUser);
		bmiRepository.save(bmi);

		return bmi;

	}

	
	
	/*
	 * public ResponseTemplateVo sendRequest(String idBmi) { Bmi bmi =
	 * bmiRepository.findByIdBmi(idBmi); ResponseTemplateVo vo = new
	 * ResponseTemplateVo(); String access_token =""; String body=""; try {
	 * RestTemplate restTemplate = new RestTemplate(); // Workaround for allowing
	 * unsuccessful HTTP Errors to still prfloat to the screen
	 * 
	 * 
	 * 
	 * HttpHeaders headers = new HttpHeaders(); headers.add("Authorization",
	 * "Bearer " + access_token);
	 * headers.setContentType(MediaType.APPLICATION_JSON); HttpEntity<String>
	 * request = new HttpEntity<String>(body, headers);
	 * 
	 * ResponseEntity<AppUser> response =
	 * restTemplate.exchange("http://localhost:8091/appUsers/" + bmi.getIdUser(),
	 * HttpMethod.GET, request, AppUser.class); vo.setBmi(bmi);
	 * vo.setAppUser(response.getBody());; return (vo); } catch (Exception e) {
	 * return(vo); } }
	 */




	/*
	 * @Override public ResponseTemplateVo getBmiWithUser(String idBmi) {
	 * ResponseTemplateVo vo = new ResponseTemplateVo(); Bmi bmi =
	 * bmiRepository.findByIdBmi(idBmi);
	 * 
	 * 
	 * AppUser appUser = restTemplate.getForObject("http://localhost:8091/appUsers/"
	 * + bmi.getIdUser(), AppUser.class);
	 * 
	 *//********************************/
	/*
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * headers.set("Authorization", "Bearer " + access_token); HttpEntity<String>
	 * entity = new HttpEntity<String>("parameters", headers);
	 * ResponseEntity<AppUser> response =
	 * restTemplate.exchange("http://localhost:8091/appUsers/" + bmi.getIdUser(),
	 * HttpMethod.GET,entity, AppUser.class); //ResponseEntity<String> res =
	 * restTemplate.exchange("http://localhost:8091/appUsers/" + bmi.getIdUser(),
	 * 
	 * 
	 *//********************************************/
	/*
	
	*//******************************************//*
													 * vo.setBmi(bmi); //vo.setAppUser(result);
													 * //System.out.prfloatln(appUser.getFullName()+"idddddd"); return vo;
													 * }
													 * 
													 */

}
