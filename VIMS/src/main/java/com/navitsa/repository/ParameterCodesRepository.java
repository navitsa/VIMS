package com.navitsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.entity.Ck_paraCodeId;
import com.navitsa.entity.ParameterCodes;
import com.navitsa.entity.TestParameter;
import com.navitsa.entity.TestParameterAngle;
import com.navitsa.entity.TestPoint;
import com.navitsa.entity.Test_type;

public interface ParameterCodesRepository extends CrudRepository<ParameterCodes, Ck_paraCodeId> {

//	@Query(value = "SELECT pc FROM ParameterCodes pc WHERE pc.testType.typeId=:typeID AND pc.testPoint.testPointID=:pointID AND pc.testParameter.testParameterId =:paraID")
//	List<ParameterCodes> getTestCodes(@Param("typeID") String typeID, @Param("pointID") String pointID, @Param("paraID") String paraID);
//
//	@Query(value = "SELECT pc FROM ParameterCodes pc WHERE pc.testType.typeId=:typeID AND pc.testPoint.testPointID=:pointID AND pc.testParameter.testParameterId =:paraID AND pc.testParameterAngle.paraAngleID=:angleID")
//	List<ParameterCodes> getTestCodes2(@Param("typeID") String typeID, @Param("pointID") String pointID, @Param("paraID") String paraID, @Param("angleID") String angleID);
//	
//	@Query(value = "SELECT pc FROM ParameterCodes pc WHERE pc.testType.typeId=:typeID AND pc.testPoint.testPointID=:pointID")
//	List<ParameterCodes> getTestCodes3(@Param("typeID") String typeID, @Param("pointID") String pointID);

//	@Transactional
//	@Modifying
//	@Query(value = "UPDATE ParameterCodes pc SET pc.operator=:operator,pc.limitValue=:limitValue,pc.minValue=:minValue,pc.maxValue=:maxValue WHERE pc.code =:code")
//	void setLimitValues(@Param("operator") String operator,@Param("limitValue") Double limitValue,@Param("minValue") Double minValue,@Param("maxValue") Double maxValue,@Param("code") String code);

	@Query(value = "SELECT pc FROM ParameterCodes pc WHERE pc.ck_paraCodeId.testType.typeId=:typeID")
	List<ParameterCodes> getTestCodes4(@Param("typeID") String typeID);

	@Query(value = "SELECT (max(pc.s_id)+1) FROM ParameterCodes pc ")
	public int maxParameterCodesSID();

	@Query(value = "SELECT pc FROM ParameterCodes pc WHERE pc.s_id=:id")
	public ParameterCodes findByParameterCodesSId(@Param("id") int id);

	@Query(value = "SELECT tt FROM Test_type tt")
	public List<Test_type> loadTestTypes();

	@Query(value = "SELECT tp FROM TestPoint tp")
	public List<TestPoint> loadTestPoints();

	@Query(value = "SELECT tp FROM TestParameter tp")
	public List<TestParameter> loadTestParameters();

	@Query(value = "SELECT tpa FROM TestParameterAngle tpa")
	public List<TestParameterAngle> loadTestParameterAngles();
}
