package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@lombok.Data
@ApiModel(description = "Customer data model")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Customer ID", example = "12312312", required = true) 
    private Long id;

    @ApiModelProperty(notes = "Username", example = "user1990", required = true) 
    private String username;

    @ApiModelProperty(notes = "password", example = "badPassword", required = true) 
    private String password;

    @ApiModelProperty(notes = "Email", example = "badEmail@gmail.com", required = true) 
    private String email;

    @ApiModelProperty(notes = "phone", example = "2225557777", required = true) 
    private String phone;

}