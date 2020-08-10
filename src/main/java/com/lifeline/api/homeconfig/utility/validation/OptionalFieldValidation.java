package com.lifeline.api.homeconfig.utility.validation;

import com.lifeline.api.homeconfig.controller.requestmodel.AddSectionRequest;
import com.lifeline.api.homeconfig.entities.type.SectionType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OptionalFieldValidation implements ConstraintValidator<OptionalField, AddSectionRequest> {

    @Override
    public void initialize(OptionalField constraintAnnotation) {}

    @Override
    public boolean isValid(AddSectionRequest addSectionRequest, ConstraintValidatorContext constraintValidatorContext) {

        SectionType currSectionType = addSectionRequest.getSectionType();
        String subTitle = addSectionRequest.getSubTitle();
        String headerTitle = addSectionRequest.getHeaderTitle();
        boolean isValid = true;

        if(currSectionType == SectionType.HEADER && !isNormalized(subTitle)){
            setCustomizedMessage(constraintValidatorContext, "Sub-title is mandatory and should be less than 50 character");
            isValid = false;

        }else if(currSectionType == SectionType.FEATURE_DESCRIPTION){
            if(!isNormalized(headerTitle)){
                setCustomizedMessage(constraintValidatorContext, "Header-title is mandatory and should be less than 50 character");
                isValid = false;
            }

            if(!isNormalized(subTitle)){
                setCustomizedMessage(constraintValidatorContext, "Sub-title is mandatory and should be less than 50 character");
                isValid = false;
            }
        }

        return isValid;
    }

    public boolean isNormalized(String field){
        return field != null && !field.isEmpty() && field.length() <= 200;
    }

    public void setCustomizedMessage(ConstraintValidatorContext constraintValidatorContext, String message){
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}