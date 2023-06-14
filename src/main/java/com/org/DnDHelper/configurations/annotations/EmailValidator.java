package com.org.DnDHelper.configurations.annotations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Matcher matcher = Pattern.compile("\\w[\\w.]*@\\w+.\\w+").matcher(s);
        System.out.println(matcher.matches());
        return matcher.matches();
    }
}
