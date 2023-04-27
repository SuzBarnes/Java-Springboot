package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertModelToEntity(UserModel userModel){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerEmail(userModel.getOwnerEmail());
        userEntity.setOwnerName(userModel.getOwnerName());
        userEntity.setPassword(userModel.getPassword());
        userEntity.setPhone(userModel.getPhone());
        return userEntity;
    }
    public UserModel convertEntityToModel (UserEntity userEntity){
        UserModel userModel = new UserModel();
        userModel.setUserId(userEntity.getId());
        userModel.setOwnerEmail(userEntity.getOwnerEmail());
        userModel.setOwnerName(userEntity.getOwnerName());
        userModel.setPhone(userEntity.getPhone());
        return userModel;
    }
}
