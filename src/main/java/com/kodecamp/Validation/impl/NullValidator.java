package com.kodecamp.Validation.impl;

import com.kodecamp.validationapi.IValidationResult;
import com.kodecamp.validationapi.IValidator;
import com.kodecamp.validationapi.ValidationResult;

/**
 * <tt>
 * This class is implementaion of IValidator 
 * which is used to check null value of object in any fields.
 * </tt>
 */

public class NullValidator implements IValidator {

	/**<tt>
	 * validate() takes object as argument checks it whether it is null or not if it
	 * is null then it put Status FAIL and message or puts Status PASS.
	 * </tt>
	 */
	private IValidator validator;
	
	public NullValidator(final IValidator validator) {
		this.validator = validator;
	}
	
	public IValidationResult validate(Object object) {

		if(this.validator != null) {
			IValidationResult vr = this.validator.validate(object);
				if(vr.status().equals(ValidationResult.Status.FAIL)) {
					return vr;
				}

		}
		return object == null ? new ValidationResult(ValidationResult.Status.FAIL, "Object is null")
				: new ValidationResult(ValidationResult.Status.PASS);
	}

	public IValidationResult validate() {
		// TODO Auto-generated method stub
		return null;
	}

}
