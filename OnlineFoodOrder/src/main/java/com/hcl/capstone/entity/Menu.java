package com.hcl.capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="food_id")
	private long foodId;
	
	@Column(name="food_categeory")
	private String foodCategeory;
	
	@Column(name="food_name")
	private String foodName;
	
	@Column(name="food_price")
	private double foodPrice;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@ManyToOne
	private Restaurant restaurant;

}
