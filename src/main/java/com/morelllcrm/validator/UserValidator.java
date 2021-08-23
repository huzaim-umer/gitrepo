package com.morelllcrm.validator;

import com.morelllcrm.entities.Users;
import org.passay.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

        Users verifyUser = (Users) o;

        String regex="^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{6,20}$";

        if (!verifyUser.getPasswordHistories().get(0).getConfirmPassword().equals(verifyUser.getPasswordHistories().get(0).getPassword()))
            errors.rejectValue("Password","invalid","Password and Confirm password must match");

        if(!verifyUser.getPasswordHistories().get(0).getPassword().matches(regex)){
            errors.rejectValue("Password","invalid","Password Strength is weak!.Please provide valid password of length atleast 6 and which has " +
                    "a number, captial alphabet, small alphabet and special character!");
        }

    }
}