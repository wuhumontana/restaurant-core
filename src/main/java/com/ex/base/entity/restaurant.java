package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@lombok.Data
@ApiModel(description = "Restaurant data model")
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Restaurant ID", example = "12312312", required = true) 
    private Long id;

    @ApiModelProperty(notes = "Restaurant name", example = "Not DiGiorno's Pizza", required = true) 
    private String name;

    @ApiModelProperty(notes = "Account", example = "adminNDPizza", required = true) 
    private String account;

    @ApiModelProperty(notes = "Password", example = "adminPassword", required = true) 
    private String password;

    @ApiModelProperty(notes = "Description", example = "Restaurant description", required = true) 
    private String description;

    @ApiModelProperty(notes = "Mobile", example = "4443337777", required = true) 
    private String mobile;

    @ApiModelProperty(notes = "Address", example = "1111 One Way Rd", required = true) 
    private String address;

    @ApiModelProperty(notes = "# of available tables of size option 1", example = "6", required = true) 
    private Integer tablesAvailable;

    @ApiModelProperty(notes = "Available tables of size option 2", example = "2", required = true) 
    private Integer tablesAvailableSZ2;

    @ApiModelProperty(notes = "Image URL", example = "https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", required = true) 
    private String image_url;

    @ApiModelProperty(notes = "Hours", example = "12", required = true) 
    private Integer hours;

    @ApiModelProperty(notes = "Restaurant status", example = "1", required = true) 
    private Integer status;
}