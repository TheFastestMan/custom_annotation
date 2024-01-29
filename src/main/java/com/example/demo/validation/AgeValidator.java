package com.example.demo.validation;

import com.example.demo.dto.UserDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeValidation, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        boolean valid = value >= 18;
        return valid;
    }
}
