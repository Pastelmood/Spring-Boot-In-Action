package com.il0v3dorayaki.demo.validator;

import com.il0v3dorayaki.demo.annotation.WalletType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class WalletTypeConstraintValidator implements ConstraintValidator<WalletType, String> {

    @Override
    public void initialize(WalletType constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        List<String> walletType = new ArrayList<>();
        walletType.add("SAVING");
        walletType.add("CHECK");

        return walletType.contains(value);
    }
}
