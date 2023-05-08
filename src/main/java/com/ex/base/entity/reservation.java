package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer customer_id;
    private Integer restaurant_id;
    private Integer table_id;
    private Integer scheduled_time;

    public reservation() {}

    public reservation(Integer customer_id, Integer restaurant_id, Integer table_id, Integer scheduled_time) {
        this.customer_id = customer_id;
        this.restaurant_id = restaurant_id;
        this.table_id = table_id;
        this.scheduled_time = scheduled_time;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getRestaurantId() {
        return restaurant_id;
    }

    public void setRestaurantId(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public Integer getTableId() {
        return table_id;
    }

    public void setTableId(Integer table_id) {
        this.table_id = table_id;
    }

    public Integer getScheduledTime() {
        return scheduled_time;
    }

    public void setScheduledTime(Integer scheduled_time) {
        this.scheduled_time = scheduled_time;
    }

}