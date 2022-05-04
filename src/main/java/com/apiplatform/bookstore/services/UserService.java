package com.apiplatform.bookstore.services;

import com.apiplatform.bookstore.Errors.Error;
import com.apiplatform.bookstore.dtos.LoginDTO;
import com.apiplatform.bookstore.dtos.UserDTO;
import com.apiplatform.bookstore.exceptions.BadRequestException;
import com.apiplatform.bookstore.models.UserModel;
import com.apiplatform.bookstore.respositories.UserRepository;
import com.apiplatform.bookstore.utils.APIResponse;
import com.apiplatform.bookstore.utils.JwtUtils;
import com.apiplatform.bookstore.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private JwtUtils jwtUtils;

    public APIResponse postUserService(UserDTO userDTO) {
        List<Error> errors = userValidator.postUserValidator(userDTO);
        if (errors.size() > 0) throw new BadRequestException("bad request", errors);
        APIResponse apiResponse = new APIResponse();
        UserModel userModel = new UserModel();
        userModel.setUserName(userDTO.getUserName());
        userModel.setGender(userDTO.getGender());
        userModel.setEmailId(userDTO.getEmailId());
        userModel.setPhoneNumber(userDTO.getPhoneNumber());
        userModel.setPassword(userDTO.getPassword());
        apiResponse.setData(HttpStatus.OK.value());
        apiResponse.setData(userRepository.insert(userModel));
        return apiResponse;
    }

    public APIResponse postLoginService(LoginDTO loginDTO) {
        List<Error> errors = userValidator.postLoginValidator(loginDTO);
        if (errors.size() > 0) throw new BadRequestException("bad request", errors);
        APIResponse apiResponse = new APIResponse();
        UserModel userModel = userRepository.findOneByEmailIdIgnoreCaseAndPassword(loginDTO.getEmailId(), loginDTO.getPassword());
        if (userModel == null) {
            apiResponse.setStatus(400);
            apiResponse.setData("UsermailId is not exit please make account first...!");
        }
        if (userModel != null) {
            apiResponse.setStatus(HttpStatus.OK.value());
            Map<String,Object> maps = new HashMap<>();
            maps.put("accesstoken",jwtUtils.generateJwt(userModel));
            apiResponse.setData(maps);
        }
        return apiResponse;
    }
}