package com.hcl.capstone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
	
	private long foodId;
	private String foodName;
	private String foodCategeory;
	private double foodPrice;
	private String imageUrl;
	private long userId;
	private String firstName;
	private String restaurentName;
	
		
}
