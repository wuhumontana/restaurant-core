package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
@ApiModel(description = "Food data model")
public class food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Food ID from database", example = "12312312", required = true) 
    private Long id;

    @ApiModelProperty(notes = "Food name", example = "Artichoke Pudding", required = true) 
    private String name;
    
    @ApiModelProperty(notes = "Food type", example = "2", required = true) 
    private Integer type;
    
    @ApiModelProperty(notes = "Food price", example = "12.99", required = true) 
    private Integer price;
   
    @ApiModelProperty(notes = "Availability", example = "1", required = true) 
    private Integer status;
}