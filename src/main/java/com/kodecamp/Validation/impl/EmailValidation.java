package com.kodecamp.Validation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kodecamp.validationapi.IValidationResult;
import com.kodecamp.validationapi.IValidator;
import com.kodecamp.validationapi.ValidationResult;
import com.kodecamp.validationapi.ValidationResult.Status;


/**
 * <tt>
 * This class is implementation of IValidator which is used to validate email  
 * This class also wraps other implementation of IValidator through its constructor for 
 * multiple validation purpose.
 * </tt>
 */

public class EmailValidation implements IValidator {

	private IValidator validator;

	public EmailValidation(final IValidator validator) {

		this.validator = validator;
	}

	public EmailValidation() {
		this(null);
	}

	/** 
	 * <tt>
	 * validate() is used to validate email string .
	 * This method first checks whether there is any other implementation of IValidator.
	 * If it found other implementation then it invokes its validate() before its own validate()
	 * @return ValidationResult
	 *  </tt>
	 */
	public IValidationResult validate(Object object) {

		Pattern p = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				
				
		Matcher m = p.matcher((CharSequence) object);
		boolean b = m.find();

		return b == false ? new ValidationResult(Status.FAIL, "Email address in not valid.")
				: new ValidationResult(Status.PASS);

	}

	public IValidationResult validate() {
		// TODO Auto-generated method stub
		return null;
	}

}
