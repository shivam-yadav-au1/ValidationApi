package com.kodecamp.Validation.impl;

import com.kodecamp.validationapi.IValidationResult;
import com.kodecamp.validationapi.IValidator;
import com.kodecamp.validationapi.ValidationResult;
import com.kodecamp.validationapi.ValidationResult.Status;


/**
 * 
 * @author shivam</br>
 *This class is used to validate phonenumber.
 */
public class PhoneNumberValidation implements IValidator{

	public IValidator validator;
	
	public PhoneNumberValidation() {
		
	}


	public PhoneNumberValidation(final IValidator validator) {
		this.validator = validator;
	}

	public IValidationResult validate(Object object) {
		if(this.validator != null) {
			IValidationResult vr = this.validator.validate(object);
			if(vr.status().equals(ValidationResult.Status.FAIL)) {
				return vr;
			}
		}
		 
		return object.toString().length() != 10 ? new ValidationResult(Status.FAIL,"Phone Number is not valid.")
				: new ValidationResult(Status.PASS);
		
	}

	public IValidationResult validate() {
		
		return null;
	}



}
