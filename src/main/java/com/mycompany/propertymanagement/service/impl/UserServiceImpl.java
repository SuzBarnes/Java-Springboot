package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.model.UserModel;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserModel register(UserModel userModel) {
        Optional<UserEntity> optUserEntity = userRepository.findByOwnerEmail(userModel.getOwnerEmail());
        if(optUserEntity.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXISTS");
            errorModel.setMessage("Email already in use.");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        else{
        UserEntity userEntity = userConverter.convertModelToEntity(userModel);
        userEntity = userRepository.save(userEntity);
        userModel = userConverter.convertEntityToModel(userEntity);}
        return userModel;
    }

    @Override
    public UserModel login(String email, String password) {
        UserModel userModel = null;
        Optional<UserEntity> optUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);
        if(optUserEntity.isPresent()){
            userModel = userConverter.convertEntityToModel(optUserEntity.get());
        } else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect email or password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userModel;
    }
}
