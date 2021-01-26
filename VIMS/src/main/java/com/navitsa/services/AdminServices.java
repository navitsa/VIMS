package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.OcrDetails;
import com.navitsa.repository.OcrDetailsRepository;

@Service
@Transactional
public class AdminServices {

	@Autowired
	OcrDetailsRepository ocrDetailsRepo;
	
	public List<OcrDetails> completedVehiclesPayment(String todayDate){
		return ocrDetailsRepo.completedVehiclesPayment(todayDate);
	}
	
}
