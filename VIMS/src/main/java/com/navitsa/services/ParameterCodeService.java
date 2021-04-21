package com.navitsa.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitsa.entity.ParameterCodes;
import com.navitsa.entity.TestParameter;
import com.navitsa.entity.TestParameterAngle;
import com.navitsa.entity.TestPoint;
import com.navitsa.entity.Test_type;
import com.navitsa.repository.ParameterCodesRepository;

@Service
public class ParameterCodeService {

	@Autowired
	ParameterCodesRepository parameterCodesRepository;

	public int maxParameterCodesSID() {
		if (parameterCodesRepository.maxParameterCodesSID() == 0) {
			return 1;
		} else {
			return parameterCodesRepository.maxParameterCodesSID();

		}
	}

	public List<ParameterCodes> getAllParameterCodes() {
		return (List<ParameterCodes>) parameterCodesRepository.findAll();
	}

	public void saveParameterCodes(@Valid ParameterCodes parameterCodes) {
		parameterCodesRepository.save(parameterCodes);
	}

	public ParameterCodes findByParameterCodesSId(int id) {
		return parameterCodesRepository.findByParameterCodesSId(id);
	}

	public List<Test_type> getAllTestTypes() {
		return (List<Test_type>) parameterCodesRepository.loadTestTypes();
	}

	public List<TestPoint> getAllTestPoints() {
		return (List<TestPoint>) parameterCodesRepository.loadTestPoints();
	}

	public List<TestParameter> getAllTestParameters() {
		return (List<TestParameter>) parameterCodesRepository.loadTestParameters();
	}

	public List<TestParameterAngle> getAllTestParameterAngles() {
		return (List<TestParameterAngle>) parameterCodesRepository.loadTestParameterAngles();
	}
}
