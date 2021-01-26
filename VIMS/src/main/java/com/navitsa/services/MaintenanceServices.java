package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitsa.entity.Repair;
import com.navitsa.repository.RepairRepository;

@Service
public class MaintenanceServices {

	@Autowired
	RepairRepository repairRepository;
	
	public List<Repair> findAllRepair() {
		return (List<Repair>) repairRepository.findAll();

	}
	public Repair saveRepair(Repair repair) {
		return  repairRepository.save(repair);

	}
	public List<Repair> getRepairtDataByDate(String repairDate) {
		return repairRepository.getRepairtDataByDate(repairDate);

	}
	
	
}
