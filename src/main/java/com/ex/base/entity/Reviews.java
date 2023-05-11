package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Review data model")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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