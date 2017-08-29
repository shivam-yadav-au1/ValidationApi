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

	public IValidationResult validate(Object object) {

		return object == null ? new ValidationResult(ValidationResult.Status.FAIL, "Object is null")
				: new ValidationResult(ValidationResult.Status.PASS);
	}

}
