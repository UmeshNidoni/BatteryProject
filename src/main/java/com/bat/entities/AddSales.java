package com.bat.entities;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddSales {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  
  @Column(name="Date")
  private Date date;
  
  @Column(name="SubDealer")
  private String sub_dealer;
  
  @Column(name="SerialNumber")
  private int serial_number;
  
  @Column(name="TotalAmount")
  private int total_amount;
  
  @Column(name="PaymentCollected")
  private int payment_collected;
  
  @Column(name="BalancePayment")
  private int balance_payment;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getSub_dealer() {
	return sub_dealer;
}

public void setSub_dealer(String sub_dealer) {
	this.sub_dealer = sub_dealer;
}

@Override
public String toString() {
	return "AddSales [id=" + id + ", date=" + date + ", sub_dealer=" + sub_dealer + ", serial_number=" + serial_number
			+ ", total_amount=" + total_amount + ", payment_collected=" + payment_collected + ", balance_payment="
			+ balance_payment + "]";
}

public AddSales() {
	super();
	// TODO Auto-generated constructor stub
}

public AddSales(int id, Date date, String sub_dealer, int serial_number, int total_amount, int payment_collected,
		int balance_payment) {
	super();
	this.id = id;
	this.date = date;
	this.sub_dealer = sub_dealer;
	this.serial_number = serial_number;
	this.total_amount = total_amount;
	this.payment_collected = payment_collected;
	this.balance_payment = balance_payment;
}

public int getSerial_number() {
	return serial_number;
}

public void setSerial_number(int serial_number) {
	this.serial_number = serial_number;
}

public int getTotal_amount() {
	return total_amount;
}

public void setTotal_amount(int total_amount) {
	this.total_amount = total_amount;
}

public int getPayment_collected() {
	return payment_collected;
}

public void setPayment_collected(int payment_collected) {
	this.payment_collected = payment_collected;
}

public int getBalance_payment() {
	return balance_payment;
}

public void setBalance_payment(int balance_payment) {
	this.balance_payment = balance_payment;
}
  
}
