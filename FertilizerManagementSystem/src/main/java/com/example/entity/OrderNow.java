package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderNow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String mobno;
	private String email;
	private String pinno;
	private int quantity;
	private String paymentmethod;

	public OrderNow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderNow(int id, String name, String address, String mobno, String email, String pinno, int quantity,
			String paymentmethod) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobno = mobno;
		this.email = email;
		this.pinno = pinno;
		this.quantity = quantity;
		this.paymentmethod = paymentmethod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPinno() {
		return pinno;
	}

	public void setPinno(String pinno) {
		this.pinno = pinno;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	@Override
	public String toString() {
		return "OrderNow [id=" + id + ", name=" + name + ", address=" + address + ", mobno=" + mobno + ", email="
				+ email + ", pinno=" + pinno + ", quantity=" + quantity + ", paymentmethod=" + paymentmethod + "]";
	}

}
