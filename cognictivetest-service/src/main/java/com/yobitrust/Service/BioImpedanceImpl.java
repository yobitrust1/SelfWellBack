package com.yobitrust.Service;

import com.yobitrust.DAO.BioImpedanceRepository;
import com.yobitrust.Models.BioImpedance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BioImpedanceImpl implements BioImpedanceService{
	
	@Autowired
	private BioImpedanceRepository bioImpedanceRepository;

	@Override
	public BioImpedance saveBioImpedance(BioImpedance bioImpedance) {
		return bioImpedanceRepository.save(bioImpedance);
	}
	
}
