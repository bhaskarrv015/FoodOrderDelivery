package com.bhaskar.FoodOrdeDelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhaskar.FoodOrdeDelivery.model.FoodOrderDeliverySystemModel;

@Repository
public interface FoodOrderDeliveryRepository extends JpaRepository<FoodOrderDeliverySystemModel,Long>{
	
}
