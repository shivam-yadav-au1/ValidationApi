package com.kodecamp.Validation.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kodecamp.validationapi.IValidationResult;
import com.kodecamp.validationapi.IValidator;
import com.kodecamp.validationapi.ValidationResult;
import com.kodecamp.validationapi.ValidationResult.Status;

public class DateValidation implements IValidator{
	
	private IValidator validator;
	
	public DateValidation() {
		
	}
	
	public DateValidation(final IValidator validator) {
		this.validator = validator;
	}

	public IValidationResult validate(Object object) {
		
		if(this.validator != null) {
	
			IValidationResult vr =this.validator.validate(object);
			if(vr.status().equals(ValidationResult.Status.FAIL)) {
				return vr;
			}
			
			
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			
			 date = sdf.parse(object.toString());
			 
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		return date instanceof Date ? new ValidationResult(Status.PASS) : new ValidationResult(Status.FAIL,"Date is invalid.");
	}

	public IValidationResult validate() {
	
		return null;
	}

}
