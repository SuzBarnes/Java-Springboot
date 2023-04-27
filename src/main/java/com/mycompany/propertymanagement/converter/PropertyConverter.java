package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.model.PropertyModel;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertModelToEntity(PropertyModel propertyModel){
        PropertyEntity pe= new PropertyEntity();
        pe.setTitle(propertyModel.getTitle());
        pe.setAddress(propertyModel.getAddress());
        pe.setOwnerEmail(propertyModel.getOwnerEmail());
        pe.setPrice(propertyModel.getPrice());
        pe.setDescription(propertyModel.getDescription());
        pe.setOwnerName(propertyModel.getOwnerName());

        return pe;
    }

    public PropertyModel convertEntityToModel(PropertyEntity propertyEntity){
        PropertyModel pm = new PropertyModel();
        pm.setId(propertyEntity.getId());
        pm.setTitle(propertyEntity.getTitle());
        pm.setAddress(propertyEntity.getAddress());
        pm.setOwnerEmail(propertyEntity.getOwnerEmail());
        pm.setPrice(propertyEntity.getPrice());
        pm.setDescription(propertyEntity.getDescription());
        pm.setOwnerName(pm.getOwnerName());
        return pm;
    }

}
