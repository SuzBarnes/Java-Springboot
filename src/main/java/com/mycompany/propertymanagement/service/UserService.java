package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.model.UserModel;

public interface UserService {
    UserModel register(UserModel userModel);
    UserModel login(String email, String password);

}
