package com.kodecamp.Validation.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kodecamp.validationapi.IValidationResult;

public class Test {

	public static void main(String args[]) {

		String s = "";
		String email = "shivam.303";
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
//			validationResult = new DateRangeValidation(new DateValidation(),"",toDate).validate();
//			validationResult = new PhoneNumberValidation().validate("1234567890");
//			validationResult = new EmptyValidator(new NullValidator()).validate("cxjh");
//		    validationResult = new PhoneNumberValidation(new EmptyValidator(new NullValidator())).validate("8795296572");
			validationResult = new EmailValidation(new EmptyValidator(new NullValidator())).validate("shivamcs0049@gmail.com");
		
		System.out.println("Status : " + validationResult.status());
		System.out.println("Message : " + validationResult.message());

	

	}

}
