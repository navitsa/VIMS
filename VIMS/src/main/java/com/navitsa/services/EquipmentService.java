package com.navitsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitsa.entity.EquipmentMake;
import com.navitsa.entity.EquipmentMaster;
import com.navitsa.entity.EquipmentModel;
import com.navitsa.entity.EquipmentType;
import com.navitsa.repository.EquipmentMakeRepository;
import com.navitsa.repository.EquipmentMasterRepository;
import com.navitsa.repository.EquipmentModelRepository;
import com.navitsa.repository.EquipmentTypeRepository;

@Service
public class EquipmentService {

	@Autowired
	EquipmentTypeRepository eqTypeRepo;
	@Autowired
	EquipmentModelRepository eqModelRepo;
	@Autowired
	EquipmentMakeRepository egMakeRepo;
	@Autowired
	EquipmentMasterRepository egMastRepo;

	public void saveEquipmentTyp(EquipmentType equipmentType) {
		eqTypeRepo.save(equipmentType);
	}

	public String maxEqTypeID() {
		if (eqTypeRepo.maxEqTypeID() == null) {
			return "1";
		} else {

			return eqTypeRepo.maxEqTypeID();
		}

	}

	public String maxEqMakeID() {

		if (egMakeRepo.maxEqMakeID() == null) {
			return "1";
		} else {

			return egMakeRepo.maxEqMakeID();
		}

	}

	public String maxEqModelID() {
		if (eqModelRepo.maxEqModelID() == null) {
			return "1";
		} else {

			return eqModelRepo.maxEqModelID();
		}

	}

	public String maxEquipmentID() {
		if (egMastRepo.maxEquipmentID() == null) {
			return "1";
		} else {

			return egMastRepo.maxEquipmentID();
		}
	}

	public List<EquipmentType> findAllEquipmentType() {
		return (List<EquipmentType>) eqTypeRepo.findAll();

	}

	public EquipmentType equipmentTypeByID(String eqId) {
		EquipmentType reselt = eqTypeRepo.findById(eqId).get();
		return reselt;
	}

	public void saveEquipmentMake(EquipmentMake equipmentMake) {
		egMakeRepo.save(equipmentMake);
	}

	public List<EquipmentMake> findAllEquipmentMake() {
		return (List<EquipmentMake>) egMakeRepo.findAll();
	}

	public EquipmentMake equipmentMakeByID(String eqmakeId) {
		EquipmentMake reselt = egMakeRepo.findById(eqmakeId).get();
		return reselt;
	}

	public void saveEquipmentModel(EquipmentModel equipmentModel) {
		eqModelRepo.save(equipmentModel);
	}

	public EquipmentModel equipmentModelByID(String eqmakeId) {
		EquipmentModel reselt = eqModelRepo.findById(eqmakeId).get();
		return reselt;
	}

	public List<EquipmentModel> findAllEquipmentModel() {
		return (List<EquipmentModel>) eqModelRepo.findAll();
	}

	public void saveEquipmentMaster(EquipmentMaster equipmentMaster) {
		egMastRepo.save(equipmentMaster);
	}

	public List<EquipmentMaster> findAllEquipmentMaster() {	
		return (List<EquipmentMaster>) egMastRepo.getfindAll();
	}

	public EquipmentMaster equipmentMasterByID(String eqMasterId) {
		EquipmentMaster reselt = egMastRepo.findById(eqMasterId).get();
		return reselt;
	}

	public List<EquipmentModel> searcheqmodel(String eqMakeid) {
		return eqModelRepo.searcheq(eqMakeid);
	}
	
	public List<EquipmentModel> searchModel(String eqMakeid,String eqTypeID) {
		return eqModelRepo.search(eqMakeid,eqTypeID);
	}
	
	public List<EquipmentMaster> searchEq(String eqModelID,String center) {
		return egMastRepo.searchEq(eqModelID,center);
	}
	
	public  List<EquipmentMaster> getEqumentDatabyEqTyoEqModel(String eqTypeid,String eqModelID){
		return egMastRepo.getEqumentDatabyEqTyoEqModel(eqTypeid, eqModelID);
	}
	
	public EquipmentMake searchLogo(String eqMakeID) {
		return egMakeRepo.searchImg(eqMakeID);
	}
	
}
