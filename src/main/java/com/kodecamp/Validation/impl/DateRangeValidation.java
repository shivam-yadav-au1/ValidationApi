package com.kodecamp.Validation.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kodecamp.validationapi.IValidationResult;
import com.kodecamp.validationapi.IValidator;
import com.kodecamp.validationapi.ValidationResult;
import com.kodecamp.validationapi.ValidationResult.Status;


/**
 * <tt>This class is used to check the range of two date.In its constructor it takes 
 * two parameters which are DateValidation and two dates which has to be compared.</tt>
 */
public class DateRangeValidation implements IValidator {
	
	private IValidator validator;
	private String  fromDate;
	private String  toDate;
	
	public DateRangeValidation(final IValidator validator,final String  fromDate,final String  toDate) {
		this.validator = validator;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public DateRangeValidation(final String fromDate,final String toDate) {
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public IValidationResult validate(Object object) {
		
		if(this.validator != null) {
			IValidationResult vr = this.validate(object);
			return vr;
		}
		return checkDate();
		
	}

	public IValidationResult validate() {
	
		
		if(this.validator != null) {
			if(!checkFromDate() && checkToDate()) {
				return new ValidationResult(Status.FAIL,"Date is not valid.");
			}
		
		}
		return checkDate();
	}
	
	private boolean checkFromDate() {
		
	
		boolean flag = false;
		
		IValidationResult vr = this.validator.validate(fromDate);
		return flag = vr.status().equals(ValidationResult.Status.FAIL) ? false : true;
	}
	
	private boolean checkToDate() {
		
		boolean flag = false;
		IValidationResult vr = this.validator.validate(toDate);
		return flag = vr.status().equals(ValidationResult.Status.FAIL) ? false :true;
	}
	
	private IValidationResult checkDate() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date from = null;
		Date to = null;
		try {
			from = sdf.parse(fromDate);
			to = sdf.parse(toDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return from.before(to) ? new ValidationResult(Status.PASS) 
				: new ValidationResult(Status.FAIL,"Date is not in range.");
	}

}
