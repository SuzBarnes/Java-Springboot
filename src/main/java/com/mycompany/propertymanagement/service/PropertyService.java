package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.model.PropertyModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {
    public PropertyModel saveProperty(PropertyModel propertyModel);
    List<PropertyModel> getAllProperties();
    PropertyModel updateProperty(PropertyModel propertyModel, Long propertyId);
    PropertyModel updatePropertyDescription(@RequestBody PropertyModel propertyModel, Long propertyId);
    PropertyModel updatePropertyPrice(@RequestBody PropertyModel propertyModel, Long propertyId);

    void deleteProperty(Long propertyId);

}
