package com.navitsa.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.navitsa.entity.EquipmentMaster;

@Component
public class EquipmentMasterValidator implements Validator {

	  @Override
	   public boolean supports(Class<?> clazz) {
	      return EquipmentMaster.class.equals(clazz);
	   }

	   @Override
	   public void validate(Object obj, Errors err) {

	    //  ValidationUtils.rejectIfEmpty(err, "eqType", "eqtype.type.empty");
	  

	   }
	
	
}
