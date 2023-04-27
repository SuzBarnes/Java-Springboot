package com.mycompany.propertymanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
    private Long userId;
    @NotNull(message = "Owner Name cannot be blank")
    private String ownerName;
    @NotNull(message = "Email cannot be blank")
    @NotEmpty(message = "Email cannot be empty")
    @Size(min=1, max=50, message="Owner email should be between 1-50 characters in length.")
    private String ownerEmail;
    @NotNull(message = "Phone number cannot be blank")
    private String phone;
    @NotNull(message = "Password cannot be blank")
    @NotEmpty(message = "Password cannot be empty")
    @Size(min=8, max=50, message="Password has to be between 8-50 characters in length.")
    private String password;
}
