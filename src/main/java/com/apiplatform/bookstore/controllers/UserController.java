package com.apiplatform.bookstore.controllers;

import com.apiplatform.bookstore.dtos.LoginDTO;
import com.apiplatform.bookstore.dtos.UserDTO;
import com.apiplatform.bookstore.services.UserService;
import com.apiplatform.bookstore.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup")
    public ResponseEntity<APIResponse> postUser(@RequestBody UserDTO userDTO) {
        APIResponse apiResponse = userService.postUserService(userDTO);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<APIResponse> postLogin(@RequestBody LoginDTO loginDTO) {
        APIResponse apiResponse = userService.postLoginService(loginDTO);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}
