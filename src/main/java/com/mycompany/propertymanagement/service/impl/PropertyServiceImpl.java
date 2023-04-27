package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.model.PropertyModel;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Value("${pms.dummy:}")
    private String dummy;
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyModel saveProperty(PropertyModel propertyModel) {
        PropertyEntity pe = propertyConverter.convertModelToEntity(propertyModel);
        pe= propertyRepository.save(pe);

        propertyModel = propertyConverter.convertEntityToModel(pe);
        return propertyModel;
    }

    @Override
    public List<PropertyModel> getAllProperties() {
        List<PropertyEntity> listOfProperties = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyModel> propertyList = new ArrayList<>();
        for(PropertyEntity pe: listOfProperties){
          PropertyModel pm =  propertyConverter.convertEntityToModel(pe);
          propertyList.add(pm);
        }
        return propertyList;
    }

    @Override
    public PropertyModel updateProperty(PropertyModel propertyModel, Long propertyId) {
        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
        PropertyModel pm = null;
        if(optEnt.isPresent()){
            PropertyEntity pe = optEnt.get();
            pe.setTitle(propertyModel.getTitle());
            pe.setDescription(propertyModel.getDescription());
            pe.setAddress(propertyModel.getAddress());
            pe.setPrice(propertyModel.getPrice());
            pm = propertyConverter.convertEntityToModel(pe);
            propertyRepository.save(pe);
        }
        return pm;
    }

    @Override
    public PropertyModel updatePropertyDescription(PropertyModel propertyModel, Long propertyId) {
        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
        PropertyModel pm = null;
        if(optEnt.isPresent()){
            PropertyEntity pe = optEnt.get();
            pe.setDescription(propertyModel.getDescription());
            pm = propertyConverter.convertEntityToModel(pe);
            propertyRepository.save(pe);
        }
        return pm;
    }

    @Override
    public PropertyModel updatePropertyPrice(PropertyModel propertyModel, Long propertyId) {
        Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
        PropertyModel pm = null;
        if(optEnt.isPresent()){
            PropertyEntity pe = optEnt.get();
            pe.setPrice(propertyModel.getPrice());
            pm = propertyConverter.convertEntityToModel(pe);
            propertyRepository.save(pe);
        }
        return pm;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
