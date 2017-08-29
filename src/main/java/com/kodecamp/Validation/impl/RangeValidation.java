package com.kodecamp.Validation.impl;

import com.kodecamp.validationapi.IValidationResult;

import com.kodecamp.validationapi.IValidator;
import com.kodecamp.validationapi.ValidationResult;
import com.kodecamp.validationapi.ValidationResult.Status;


/**
 * <tt>
 * This class is implementation of IValidator which is used to check range of any string 
 * This class also wraps other implementation of IValidator through its constructor for 
 * multiple validation purpose.
 * </tt>
 */

public class RangeValidation implements IValidator {

	private IValidator validator;
	private int min;
	private int max;

	public RangeValidation(final IValidator validator) {
		this.validator = validator;
	}

	public RangeValidation() {
		this(null);
	}

	public RangeValidation(final IValidator validator, final int min, int max) {

		this.min = min;
		this.max = max;
		this.validator = validator;
	}
	/**<tt>
	 * validate() takes object as argument checks it whether it is null or not if it
	 * is null then it put Status FAIL and message or puts Status PASS.
	 * </tt>
	 */
	
	
	public IValidationResult validate(Object object) {

		String in = (String) object;
		int input = Integer.parseInt(in);
	
		if (input >= min && input <= max) {
			return new ValidationResult(Status.PASS);
		} else {
			return new ValidationResult(Status.FAIL, "Number is not in range");
		}

	}

}
