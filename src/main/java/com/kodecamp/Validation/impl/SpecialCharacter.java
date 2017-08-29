package com.kodecamp.Validation.impl;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import com.kodecamp.validationapi.IValidationResult;
import com.kodecamp.validationapi.IValidator;
import com.kodecamp.validationapi.ValidationResult;
import com.kodecamp.validationapi.ValidationResult.Status;



/**<tt>
 * This class is implementation of IValidator which is used to check whether any string 
 * contain special character.
 * This class also wraps other implementation of IValidator through its constructor for 
 * multiple validation purpose.
 * </tt>
 */
public class SpecialCharacter implements IValidator {

	private IValidator validator;

	public SpecialCharacter(final IValidator validator) {
		this.validator = validator;
	}

	public SpecialCharacter() {
		this(null);
	}

	/**<tt>
	 * validate() is used to validate special character string . This method first checks
	 * whether there is any other implementation of IValidator. If it found other
	 * implementation then it invokes its validate() before its own validate()
	 * </tt>
	 * 
	 */
	
	


	public IValidationResult validate(Object object) {

		if (this.validator != null) {
			IValidationResult vr = this.validator.validate(object);
			if (vr.status().equals(ValidationResult.Status.FAIL)) {
				return vr;
			}
		}
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		Matcher m = p.matcher((CharSequence) object);
		boolean b = m.find();
		return b == true ? new ValidationResult(Status.FAIL, "Object contains some special Character.")
				: new ValidationResult(Status.PASS);
	}

}
