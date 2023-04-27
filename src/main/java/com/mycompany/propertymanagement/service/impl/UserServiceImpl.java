package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.model.UserModel;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserModel register(UserModel userModel) {
        UserEntity userEntity = userConverter.convertModelToEntity(userModel);
        userEntity = userRepository.save(userEntity);
        userModel = userConverter.convertEntityToModel(userEntity);
        return userModel;
    }

    @Override
    public UserModel login(String email, String password) {
        return null;
    }
}
