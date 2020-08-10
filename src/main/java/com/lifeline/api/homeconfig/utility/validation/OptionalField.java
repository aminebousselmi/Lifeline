package com.lifeline.api.homeconfig.utility.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OptionalFieldValidation.class)
public @interface OptionalField {
    String message() default "";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload> [] payload() default {};
}
