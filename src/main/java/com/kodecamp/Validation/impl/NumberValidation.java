package com.kodecamp.Validation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kodecamp.validationapi.IValidationResult;
import com.kodecamp.validationapi.IValidator;
import com.kodecamp.validationapi.ValidationResult;
import com.kodecamp.validationapi.ValidationResult.Status;



public class NumberValidation implements IValidator {

	private IValidator validator;

	public NumberValidation(final IValidator validator) {
		this.validator = validator;
	}

	public NumberValidation() {
		this(null);
	}
	/**
	 * <tt>
	 * This method is used to validate number in a given string.
	 * This method first check whether there is any other implementation of IValidator.
	 * if other implementation  is found then it invoke its validate() before its own .
	 * @return ValidationResult
	 */
	
	public IValidationResult validate(Object object) {

		if (this.validator != null) {
			IValidationResult vr = this.validator.validate(object);
			if (vr.status().equals(ValidationResult.Status.FAIL)) {
				return vr;

			}
		}
		Pattern p = Pattern.compile("([0-9])");
		Matcher m = p.matcher((CharSequence) object);
		boolean b = m.find();
		return b == true ? new ValidationResult(Status.FAIL, "Object contains Number.")
				: new ValidationResult(Status.PASS);

	}

	public IValidationResult validate() {
		// TODO Auto-generated method stub
		return null;
	}

}
