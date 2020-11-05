package com.navitsa.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.navitsa.entity.EquipmentType;


@Component
public class EquipmentTypeValidator implements Validator {

   @Override
   public boolean supports(Class<?> clazz) {
      return EquipmentType.class.equals(clazz);
   }

   @Override
   public void validate(Object obj, Errors err) {

	  ValidationUtils.rejectIfEmpty(err, "eqTypeID", "eqtype.eqTypeID.empty");
      ValidationUtils.rejectIfEmpty(err, "eqType", "eqtype.type.empty");
      ValidationUtils.rejectIfEmpty(err, "remark", "eqtype.remark.empty");
      ValidationUtils.rejectIfEmpty(err, "status", "eqtype.status.empty");
    /*  ValidationUtils.rejectIfEmpty(err, "email", "user.email.empty");
      ValidationUtils.rejectIfEmpty(err, "gender", "user.gender.empty");
      ValidationUtils.rejectIfEmpty(err, "languages", "user.languages.empty");*/

    /*  EquipmentType equipmentType = (EquipmentType) obj;*/

   /*   Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);
      if (!(pattern.matcher(user.getEmail()).matches())) {
         err.rejectValue("email", "user.email.invalid");
      }*/

   }

}
