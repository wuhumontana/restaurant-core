package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String account;
    private String password;
    private String description;
    private String mobile;
    private String address;
    private Integer tablesAvailable;
    private Integer tablesAvailableSZ2;
    private String image_url;
    private Integer hours;
    private Integer status;

    public restaurant() {}

    public restaurant(String name, String account, String password, String description,
                      String mobile, String address, Integer tablesAvailable,
                      Integer tablesAvailableSZ2, String image_url, Integer hours, Integer status) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.description = description;
        this.mobile = mobile;
        this.address = address;
        this.tablesAvailable = tablesAvailable;
        this.tablesAvailableSZ2 = tablesAvailableSZ2;
        this.image_url = image_url;
        this.hours = hours;
        this.status = status;
    }

    public Long getID() { return id; }
    public void setID(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Integer getTablesAvailable() { return tablesAvailable; }
    public void setTablesAvailable(Integer tablesAvailable) { this.tablesAvailable = tablesAvailable; }
    public Integer getTablesAvailableSZ2() { return tablesAvailableSZ2; }
    public void setTablesAvailableSZ2(Integer tablesAvailableSZ2) { this.tablesAvailableSZ2 = tablesAvailableSZ2; }
    public String getImage_url() { return image_url; }
    public void setImage_url(String image_url) { this.image_url = image_url; }
    public Integer getHours() { return hours; }
    public void setHours(Integer hours) { this.hours = hours; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}