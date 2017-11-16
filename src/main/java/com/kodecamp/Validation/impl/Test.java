package com.kodecamp.Validation.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kodecamp.validationapi.IValidationResult;

public class Test {

	public static void main(String args[]) {

		String s = "sunil kumar?";
		String email = "shivam@gmail.com";
		String allowedChars[] = {" ","*"};
		/*IValidationResult validationResult = new EmailValidation(new RangeValidation(
													new NumberValidation(
															new EmptyValidator(
																			new NullValidator()))),4,8).validate(email);
	*/

		String fromDate = "06-06-2017";
		String toDate = "14-11-2017";

		IValidationResult validationResult = null;
		
//			validationResult = new DateRangeValidation(fromDate,toDate).validate();
//			validationResult = new DateValidation().validate(fromDate);
//			validationResult = new DateRangeValidation(new DateValidation(),fromDate,toDate).validate();
			validationResult = new PhoneNumberValidation().validate("1234567890");
		
		
		
		System.out.println("Status : " + validationResult.status());
		System.out.println("Message : " + validationResult.message());

	

	}

}
