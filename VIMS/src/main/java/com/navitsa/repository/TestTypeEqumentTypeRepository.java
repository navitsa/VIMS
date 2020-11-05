package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.EquipmentType;
import com.navitsa.entity.TestTypeEqumentType;

public interface TestTypeEqumentTypeRepository  extends CrudRepository<TestTypeEqumentType, Integer>{
	
	@Query(value="SELECT et FROM EquipmentType et,TestTypeEqumentType te WHERE te.typeId.typeId=:testType and te.eqTypeID.eqTypeID=et.eqTypeID")
	public List<EquipmentType> getEqupmentTypeByTestType(@Param("testType")String testType);

}
