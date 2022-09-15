package com.yobitrust.Service;

import com.yobitrust.DAO.CardiacRepository;
import com.yobitrust.Models.Cardiac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CardiacServiceImpl implements CardiacService {

	@Autowired
	private CardiacRepository cardiacRepository;

	@Override
	public Cardiac saveCardiac(Cardiac cardiac) {
		return cardiacRepository.save(cardiac);
	}
	
}
