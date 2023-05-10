package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Review data model")
@Data
@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Review ID", example = "1", required = true)
    private Long id;
    @ApiModelProperty(notes = "Restaurant ID", example = "1", required = true)
    private Integer restaurant_id;
    @ApiModelProperty(notes = "Customer ID", example = "1", required = true)
    private Integer customer_id;
    @ApiModelProperty(notes = "Reservation ID", example = "1", required = true)
    private Integer reservation_id;
    @ApiModelProperty(notes = "Score", example = "5", required = true)
    private Integer score;
    @ApiModelProperty(notes = "Content", example = "Great restaurant!", required = false)
    private String content;

}