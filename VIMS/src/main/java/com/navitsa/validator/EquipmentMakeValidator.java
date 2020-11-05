package com.navitsa.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.navitsa.entity.EquipmentMake;

@Component
public class EquipmentMakeValidator implements Validator {

   @Override
   public boolean supports(Class<?> clazz) {
      return EquipmentMake.class.equals(clazz);
   }

   @Override
   public void validate(Object obj, Errors err) {

    //ValidationUtils.rejectIfEmpty(err, "eqMake", "eqmake.eqMake.empty");
   // ValidationUtils.rejectIfEmpty(err, "eqMakeID", "eqmake.eqMakeID.empty");
   // ValidationUtils.rejectIfEmpty(err, "eqMakeLogo", "eqmake.eqMakeLogo.empty");
    //ValidationUtils.rejectIfEmpty(err, "status", "eqmake.status.empty");

	   

   }

}
