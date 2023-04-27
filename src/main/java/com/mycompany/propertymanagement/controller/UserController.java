package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.model.UserModel;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody UserModel userModel){
        userModel = userService.register(userModel);
        return  new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody UserModel userModel){
        userModel = userService.login(userModel.getOwnerEmail(), userModel.getPassword());
        return  new ResponseEntity<>(userModel, HttpStatus.OK);
    }
}
