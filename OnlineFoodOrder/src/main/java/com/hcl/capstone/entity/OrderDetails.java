//package com.hcl.capstone.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name="order_details")
//public class OrderDetails {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="order_id")
//	private long orderId;
//	
//	@Column(name = "total_quantity")
//	private int totalQuantity;
//	
//	@Column(name = "total_price")
//	private double totalPrice;
//	
//	@ManyToOne
//	@JoinColumn(name="address_id")
//	private Address address;
//	
//	@ManyToOne
//	@JoinColumn(name="user_id")
//	private User user;
//
//}
