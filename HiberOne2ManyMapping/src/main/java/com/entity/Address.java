package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address 
{

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="address_id")
   private int id;
   
   @Column(name="city")
   private String city;
   
   @Column(name="pincode")
   private String pincode;
   
   @ManyToOne(cascade=CascadeType.ALL)
   private Customer customer;

public Address(int id, String city, String pincode, Customer customer) {
	super();
	this.id = id;
	this.city = city;
	this.pincode = pincode;
	this.customer = customer;
}

public Address() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getPincode() {
	return pincode;
}

public void setPincode(String pincode) {
	this.pincode = pincode;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

@Override
public String toString() {
	return "Address [id=" + id + ", city=" + city + ", pincode=" + pincode + ", customer=" + customer + "]";
}
   
   
	
   
   
}
