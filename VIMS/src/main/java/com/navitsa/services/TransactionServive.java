package com.navitsa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitsa.entity.Transaction;
import com.navitsa.repository.TransactionRepository;

@Service
public class TransactionServive {

	
	@Autowired
	TransactionRepository traRepo;
	
	 public String maxtrID() {
			if(traRepo.maxtrID()==null) {
				return "1";
			} else {	
				return traRepo.maxtrID();
			}
		}
	 
	 public void saveTransaction(Transaction tr) {
		 traRepo.save(tr);
		} 
	 
	 public Transaction getTrancionByID(String id) {
		 return traRepo.findById(id).get();
		} 
	 
}
