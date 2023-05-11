package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Seating data model")
@Data
@Entity
public class Seating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Seating ID", example = "1", required = true)
    private Long id;
    @ApiModelProperty(notes = "Restaurant ID", example = "1", required = true)
    private Integer restaurant_id;
    @ApiModelProperty(notes = "Table Number", example = "1", required = true)
    private Integer table_number;
    @ApiModelProperty(notes = "Table Size", example = "1", required = true)
    private Integer table_size;
    @ApiModelProperty(notes = "Capacity", example = "4", required = true)
    private Integer capacity;
    @ApiModelProperty(notes = "Status", example = "1", required = true)
    private Integer status;
}