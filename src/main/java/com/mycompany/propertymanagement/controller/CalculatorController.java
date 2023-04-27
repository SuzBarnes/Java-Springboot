package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.model.CalculatorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator") //class level mapping of url => controller class

public class CalculatorController {
    @GetMapping("/add") // method level mapping of url to a controller function
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        return num1+num2;
    }

    @GetMapping("/subtract/{num1}/{num2}")
    public Double subtract (@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result = null;
        if(num1>num2){
            result= num1-num2;}
        else{
            result = num2-num1;
        };
                return result;
    }

    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorModel calculatorModel){

        Double result = null;
        result = calculatorModel.getNum1()*calculatorModel.getNum2()*calculatorModel.getNum3()*calculatorModel.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
