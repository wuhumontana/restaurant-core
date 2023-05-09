package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer restaurant_id;
    private Integer table_number;
    private Integer table_size;
    private Integer capacity;
    private Integer status;


    public Seating() {}

    public Seating(Integer restaurant_id, Integer table_number, Integer table_size, Integer capacity, Integer status) {
        this.restaurant_id = restaurant_id;
        this.table_number = table_number;
        this.table_size = table_size;
        this.capacity = capacity;
        this.status = status;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public Integer getRestaurantId() {
        return restaurant_id;
    }

    public void setRestaurantId(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public Integer getTableNumber() {
        return table_number;
    }

    public void setTableNumber(Integer table_number) {
        this.table_number = table_number;
    }

    public Integer getTableSize() {
        return table_size;
    }

    public void setTableSize(Integer table_size) {
        this.table_size = table_size;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}