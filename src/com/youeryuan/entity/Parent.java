package com.youeryuan.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("parent")
public class Parent extends Person{
	
	protected String username;
	protected String password;
	protected String phone;
	protected String email;
	protected String IDCard;
	protected String province;
	protected String city;
	protected String county;
	protected String address;
	protected String createDate;
	protected List<Child> children;
	protected List<School> loveSchools;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public List<Child> getChildren() {
		return children;
	}
	public void setChildren(List<Child> children) {
		this.children = children;
	}
	public List<School> getLoveSchools() {
		return loveSchools;
	}
	public void setLoveSchools(List<School> loveSchools) {
		this.loveSchools = loveSchools;
	}

}
