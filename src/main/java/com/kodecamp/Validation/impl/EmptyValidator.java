package com.kodecamp.Validation.impl;

import com.kodecamp.validationapi.IValidationResult;
import com.kodecamp.validationapi.IValidator;
import com.kodecamp.validationapi.ValidationResult;
import com.kodecamp.validationapi.ValidationResult.Status;

/**
 * <tt>
 * This class is implementation of IValidator which is used to check whether any string 
 * is empty or not.
 * This class also wraps other implementation of IValidator through its constructor for 
 * multiple validation purpose.
 * </tt>
 */
public class EmptyValidator implements IValidator {

	private IValidator validator;

	// Parametrized constructor
	
	public EmptyValidator(final IValidator validator) {
		this.validator = validator;

	}
	
	// Constructor
	public EmptyValidator() {
		
	}
	
	/**
	 * <tt>
	 * validate() is used to validate empty string .
	 * This method first checks whether there is any other implementation of IValidator.
	 * If it found other implementation then it invokes its validate() before its own validate()
	 * @return ValidationResult
	 * </tt>
	 */

	public IValidationResult validate(Object object) {
		
		
		
		if (this.validator != null) {
			IValidationResult vr = this.validator.validate(object);
			if (vr.status().equals(ValidationResult.Status.FAIL)) {
				return vr;
			}
		}
		String value = (String) object;
		
		return "".equals(value.trim()) ? new ValidationResult(Status.FAIL, "Field is empty.")
				: new ValidationResult(Status.PASS);
	}

	public IValidationResult validate() {
		// TODO Auto-generated method stub
		return null;
	}

}
