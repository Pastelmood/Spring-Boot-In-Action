package com.il0v3dorayaki.demo.annotation;

import com.il0v3dorayaki.demo.validator.WalletTypeConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = WalletTypeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WalletType {

    // define default error message
    public String message() default "Field type must be 'SAVING' or 'CHECK'";

    // define default group
    public Class<?>[] groups() default {};

    // define default payload
    // Payloads: provide custom details about validation failure
    // (severity level, error code etc)
    public Class<? extends Payload>[] payload() default {};

}
