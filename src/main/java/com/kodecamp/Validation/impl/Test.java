package com.kodecamp.Validation.impl;

import com.kodecamp.validationapi.IValidationResult;

public class Test {

	public static void main(String args[]) {

		String email = "shivamgmail@com.in";
		IValidationResult validationResult = new EmailValidation(new RangeValidation(
													new NumberValidation(
															new SpecialCharacter(
																	new EmptyValidator(
																			new NullValidator()))),4,8)).validate(email);
	
	
		System.out.println("Status : " + validationResult.status());
		System.out.println("Message : " + validationResult.message());

		/*
		 * IValidationResult nullValidation = new NullValidator().validate(name);
		 * if(nullValidation.status().equals(ValidationResult.Status.PASS)) {
		 * IValidationResult vr = new EmptyValidator().validate(name);
		 * System.out.println("Status : " + vr.status());
		 * System.out.println("Message : " + vr.message()); } else {
		 * System.out.println("NullValidation Failed "); }
		 */

	}

}
