package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@lombok.Data

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

    public Reservation() {}

    public Reservation(Integer customer_id, Integer restaurant_id, Integer table_id, Integer table_size, String date, Integer scheduled_time) {
        this.customer_id = customer_id;
        this.restaurant_id = restaurant_id;
        this.table_id = table_id;
        this.table_size = table_size;
        this.date = date;
        this.scheduled_time = scheduled_time;
    }


}