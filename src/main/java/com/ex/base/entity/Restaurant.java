package com.ex.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DROP TABLE IF EXISTS `restaurant`;
// CREATE TABLE restaurant(
//   `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'primary key, self-increment，step size is 1',
//   `name` VARCHAR(30) NOT NULL COMMENT'restaurant name',
//   `account` VARCHAR(30) NOT NULL COMMENT'management account',
//   `password` VARCHAR(20) DEFAULT NULL COMMENT 'password',
//   `description` VARCHAR(20) DEFAULT NULL COMMENT'description',
//   `mobile` VARCHAR(20) NOT NULL COMMENT 'mobile',
//   `address` VARCHAR(100) NOT NULL COMMENT 'address',

//   `image_url` text DEFAULT NULL COMMENT 'image url',

//   `open_time` DATETIME DEFAULT NULL COMMENT 'open time',
//   `close_time` DATETIME DEFAULT NULL COMMENT 'close time',
//   `status` TINYINT UNSIGNED DEFAULT 0 COMMENT 'status, 0-closed，1-opening',

//   `gmt_create` DATETIME DEFAULT NOW() COMMENT'created time',
//   `gmt_modified` DATETIME DEFAULT NOW() ON UPDATE NOW() COMMENT'updated time',
//   PRIMARY KEY (`id`)
// ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='restaurant table';

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String account;
    private String password;
    private String description;
    private String mobile;
    private String address;
    private String imageUrl;

    private Integer openTime;
    private Integer closeTime;
    private Integer status;

    public Restaurant() {
        
	}

	public Restaurant(Long id, String name, String account, String password, String description, String mobile,
			String address, String imageUrl, Integer openTime, Integer closeTime, Integer status) {
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.description = description;
		this.mobile = mobile;
		this.address = address;
		this.imageUrl = imageUrl;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.status = status;
	}

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Integer openTime) {
		this.openTime = openTime;
	}
	public Integer getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Integer closeTime) {
		this.closeTime = closeTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
