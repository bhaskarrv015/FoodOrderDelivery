package com.bhaskar.FoodOrdeDelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class FoodOrderDeliverySystemModel {
	@Id
	@GeneratedValue
	@Column(name="foodOrderid")
	private Long foodOrderid;
	@Column(name="Food_Order_Name")
	private String foodOrderName;
	
	public FoodOrderDeliverySystemModel()
	{
		
	}
	
	
	public FoodOrderDeliverySystemModel(Long foodOrderid, String foodOrderName) {
		super();
		this.foodOrderid = foodOrderid;
		this.foodOrderName = foodOrderName;
	}
	public Long getFoodOrderid() {
		return foodOrderid;
	}
	public void setFoodOrderid(Long foodOrderid) {
		this.foodOrderid = foodOrderid;
	}
	public String getFoodOrderName() {
		return foodOrderName;
	}
	public void setFoodOrderName(String foodOrderName) {
		this.foodOrderName = foodOrderName;
	}
	@Override
	public String toString() {
		return "FoodOrderDeliverySystemModel [foodOrderid=" + foodOrderid + ", foodOrderName=" + foodOrderName + "]";
	}
	
	
	
	

}
