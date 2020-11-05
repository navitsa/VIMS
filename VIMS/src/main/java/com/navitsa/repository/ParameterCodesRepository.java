package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.navitsa.entity.ParameterCodes;

public interface ParameterCodesRepository extends CrudRepository<ParameterCodes, String> {

	@Query(value = "SELECT pc FROM ParameterCodes pc WHERE pc.testType.typeId=:typeID AND pc.testPoint.testPointID=:pointID AND pc.testParameter.testParameterId =:paraID")
	List<ParameterCodes> getTestCodes(@Param("typeID") String typeID, @Param("pointID") String pointID, @Param("paraID") String paraID);

	@Query(value = "SELECT pc FROM ParameterCodes pc WHERE pc.testType.typeId=:typeID AND pc.testPoint.testPointID=:pointID AND pc.testParameter.testParameterId =:paraID AND pc.testParameterAngle.paraAngleID=:angleID")
	List<ParameterCodes> getTestCodes2(@Param("typeID") String typeID, @Param("pointID") String pointID, @Param("paraID") String paraID, @Param("angleID") String angleID);
	
	@Query(value = "SELECT pc FROM ParameterCodes pc WHERE pc.testType.typeId=:typeID AND pc.testPoint.testPointID=:pointID")
	List<ParameterCodes> getTestCodes3(@Param("typeID") String typeID, @Param("pointID") String pointID);

	@Transactional
	@Modifying
	@Query(value = "UPDATE ParameterCodes pc SET pc.operator=:operator,pc.limitValue=:limitValue,pc.minValue=:minValue,pc.maxValue=:maxValue WHERE pc.code =:code")
	void setLimitValues(@Param("operator") String operator,@Param("limitValue") Double limitValue,@Param("minValue") Double minValue,@Param("maxValue") Double maxValue,@Param("code") String code);
}
