package com.lumar.validation;

import java.lang.annotation.*;


import javax.validation.*;


@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DirectoryValidator.class)

public @interface DirectoryPath {
	  String message() default "{com.johnson.InvalidPath.message}";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
	
	
}
