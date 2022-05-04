package com.apiplatform.bookstore.validators;

import com.apiplatform.bookstore.Errors.Error;
import com.apiplatform.bookstore.dtos.LoginDTO;
import com.apiplatform.bookstore.dtos.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator {

    public List<Error> postUserValidator(UserDTO userDTO) {
        List<Error> errors = new ArrayList<>();
        if (userDTO.getUserName() == null) {
            errors.add(new Error("username", "username is null"));
        }
        if (userDTO.getGender() == null) {
            errors.add(new Error("gender", "gender is null"));
        }
        if (userDTO.getEmailId() == null) {
            errors.add(new Error("emailid", "emailid is null"));
        }
        if (userDTO.getPhoneNumber() == null) {
            errors.add(new Error("phonenumber", "phonenumber is null"));
        }
        if (userDTO.getPassword() == null) {
            errors.add(new Error("password", "password is null"));
        }
        return errors;
    }

    public List<Error> postLoginValidator(LoginDTO loginDTO) {
        List<Error> errors = new ArrayList<>();
        if (loginDTO.getEmailId() == null) {
            errors.add(new Error("emailid", "emailid is null"));
        }
        if (loginDTO.getPassword() == null) {
            errors.add(new Error("password", "password is null"));
        }
        return errors;
    }
}
