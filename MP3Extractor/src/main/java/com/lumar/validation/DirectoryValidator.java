package com.lumar.validation;

import java.io.File;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DirectoryValidator implements ConstraintValidator<DirectoryPath,String> {
	
	@Override 
public void initialize(DirectoryPath path){}
	

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("checking if valid");
	File file = new File(value);

		return file.isDirectory();
	}


}
