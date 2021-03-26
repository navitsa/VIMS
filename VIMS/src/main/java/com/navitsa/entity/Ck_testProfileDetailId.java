package com.navitsa.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class Ck_testProfileDetailId implements Serializable{

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id",referencedColumnName = "profile_id")
	private TestProfile testProfileHeaderID;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(
            name = "code",
            referencedColumnName = "code"),
        @JoinColumn(
            name = "type_id",
            referencedColumnName = "type_id")
    })
    private ParameterCodes parameterCode;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_cat_id",referencedColumnName = "categoryID")
	private VehicleCategory vehicleCat;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_sub_cat_id",referencedColumnName = "subCategoryID")
	private VehiclesSubCategory subCategoryID;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "rule",referencedColumnName = "rule_code")
	private TestLimitRule testLimitRule;

	public TestProfile getTestProfileHeaderID() {
		return testProfileHeaderID;
	}

	public void setTestProfileHeaderID(TestProfile testProfileHeaderID) {
		this.testProfileHeaderID = testProfileHeaderID;
	}

	public ParameterCodes getParameterCode() {
		return parameterCode;
	}

	public void setParameterCode(ParameterCodes parameterCode) {
		this.parameterCode = parameterCode;
	}

	public VehicleCategory getVehicleCat() {
		return vehicleCat;
	}

	public void setVehicleCat(VehicleCategory vehicleCat) {
		this.vehicleCat = vehicleCat;
	}

	public VehiclesSubCategory getSubCategoryID() {
		return subCategoryID;
	}

	public void setSubCategoryID(VehiclesSubCategory subCategoryID) {
		this.subCategoryID = subCategoryID;
	}

	public TestLimitRule getTestLimitRule() {
		return testLimitRule;
	}

	public void setTestLimitRule(TestLimitRule testLimitRule) {
		this.testLimitRule = testLimitRule;
	}

	public Ck_testProfileDetailId(TestProfile testProfileHeaderID, ParameterCodes parameterCode,
			VehicleCategory vehicleCat, VehiclesSubCategory subCategoryID, TestLimitRule testLimitRule) {
		super();
		this.testProfileHeaderID = testProfileHeaderID;
		this.parameterCode = parameterCode;
		this.vehicleCat = vehicleCat;
		this.subCategoryID = subCategoryID;
		this.testLimitRule = testLimitRule;
	}

	public Ck_testProfileDetailId() {
	}
	
}
