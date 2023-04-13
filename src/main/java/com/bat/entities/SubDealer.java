package com.bat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubDealer {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String subDealerName;

private String contact;

private String address;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getSubDealerName() {
	return subDealerName;
}

public void setSubDealerName(String subDealerName) {
	this.subDealerName = subDealerName;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public SubDealer(int id, String subDealerName, String contact, String address) {
	super();
	this.id = id;
	this.subDealerName = subDealerName;
	this.contact = contact;
	this.address = address;
}

public SubDealer() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "SubDealer [id=" + id + ", subDealerName=" + subDealerName + ", contact=" + contact + ", address=" + address
			+ "]";
}



}
