package com.navitsa.services;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.Gate;
import com.navitsa.entity.OcrDetails;
import com.navitsa.entity.VehicleClass;
import com.navitsa.repository.GateRepository;
import com.navitsa.repository.OcrDetailsRepository;

@Service
@Transactional
public class AdminServices {

	@Autowired
	OcrDetailsRepository ocrDetailsRepo;
	@Autowired
	GateRepository gateRepository;
	
	public List<OcrDetails> completedVehiclesPayment(String todayDate){
		return ocrDetailsRepo.completedVehiclesPayment(todayDate);
	}
	
	public void saveGates(Gate gate) {
		gateRepository.save(gate);
	}
	
	public List<Gate> getAllGeats(){
		return (List<Gate>) gateRepository.findAll();
	}

	public String maxGateID() {
		if(gateRepository.maxGateID() == null) {
			return "1";
		} else {
		return gateRepository.maxGateID();
	
		}
	}

	public List<Gate> getAllGates() {
		return (List<Gate>) gateRepository.findAll();
	}

	public void saveCreatedGate(@Valid Gate gate) {
		gateRepository.save(gate);
	}

	public Gate getGateById(String id) {
		return gateRepository.findById(id).get();
	}
}
