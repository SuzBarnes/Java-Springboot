package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.model.PropertyModel;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {
    @Value("${pms.dummy:}")
    private String dummy;
    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello how are you?";
    }
    @PostMapping("/properties")
    public ResponseEntity<PropertyModel> saveProperty(@RequestBody PropertyModel propertyModel){
        propertyModel = propertyService.saveProperty(propertyModel);
        ResponseEntity<PropertyModel> responseEntity = new ResponseEntity<>(propertyModel, HttpStatus.CREATED);
        return responseEntity;
    }
    @GetMapping("/properties")
    public ResponseEntity<List<PropertyModel>> getAllProperties(){
        System.out.println(dummy);
       List<PropertyModel> propertyList =  propertyService.getAllProperties();
        ResponseEntity<List<PropertyModel>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;

    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyModel> updateProperty(@RequestBody PropertyModel propertyModel, @PathVariable Long propertyId){
       propertyModel =  propertyService.updateProperty(propertyModel, propertyId);
       ResponseEntity<PropertyModel> responseEntity = new ResponseEntity<>(propertyModel, HttpStatus.CREATED);
       return responseEntity;
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyModel> updatePropertyDescription(@RequestBody PropertyModel propertyModel,@PathVariable Long propertyId){
        propertyModel =  propertyService.updatePropertyDescription(propertyModel, propertyId);
        ResponseEntity<PropertyModel> responseEntity = new ResponseEntity<>(propertyModel, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyModel> updatePropertyPrice(@RequestBody PropertyModel propertyModel, @PathVariable Long propertyId){
        propertyModel =  propertyService.updatePropertyPrice(propertyModel, propertyId);
        ResponseEntity<PropertyModel> responseEntity = new ResponseEntity<>(propertyModel, HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
