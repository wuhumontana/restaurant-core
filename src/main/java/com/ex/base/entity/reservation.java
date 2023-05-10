package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@lombok.Data
@ApiModel(description = "Reservation data model")
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ApiModelProperty(notes = "Reservation ID", example = "12312312", required = true) 
    private Long id;

    @ApiModelProperty(notes = "Customer ID", example = "12312312", required = true) 
    private Integer customer_id;

    @ApiModelProperty(notes = "Restaurant ID", example = "12312312", required = true) 
    private Integer restaurant_id;

    @ApiModelProperty(notes = "Table ID", example = "12312312", required = true) 
    private Integer table_id;

    @ApiModelProperty(notes = "Table size", example = "12312312", required = true) 
    private Integer table_size;

    @ApiModelProperty(notes = "Date of Reservation", example = "11-15-2023", required = true) 
    private String date;

    @ApiModelProperty(notes = "Time of Reservation (hour of day)", example = "12", required = true) 
    private Integer scheduled_time;
}