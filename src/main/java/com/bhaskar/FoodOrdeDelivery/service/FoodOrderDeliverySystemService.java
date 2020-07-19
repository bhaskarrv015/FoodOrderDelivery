package com.bhaskar.FoodOrdeDelivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhaskar.FoodOrdeDelivery.Exception.RecordNotFoundException;
import com.bhaskar.FoodOrdeDelivery.model.FoodOrderDeliverySystemModel;
import com.bhaskar.FoodOrdeDelivery.repository.FoodOrderDeliveryRepository;

@Service
public class FoodOrderDeliverySystemService {

	@Autowired
	FoodOrderDeliveryRepository foodOrderRepository;
	
	public List<FoodOrderDeliverySystemModel> getAllFoodOrders()
    {
        List<FoodOrderDeliverySystemModel> foodOrderList = foodOrderRepository.findAll();
         
        if(foodOrderList.size() > 0) {
            return foodOrderList;
        } else {
            return new ArrayList<FoodOrderDeliverySystemModel>();
        }
    }
	
	 public FoodOrderDeliverySystemModel getFoodOrderById(Long id) throws RecordNotFoundException 
	    {
	        Optional<FoodOrderDeliverySystemModel> foodOrder = foodOrderRepository.findById(id);
	         
	        if(foodOrder.isPresent()) {
	            return foodOrder.get();
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    }
	 
	 public FoodOrderDeliverySystemModel createOrUpdateFoodOrderDelivery(FoodOrderDeliverySystemModel entity) throws RecordNotFoundException 
	    {
	        Optional<FoodOrderDeliverySystemModel> foodOrder = foodOrderRepository.findById(entity.getFoodOrderid());
	         
	        if(foodOrder.isPresent()) 
	        {
	        	FoodOrderDeliverySystemModel newEntity = foodOrder.get();
	            newEntity.setFoodOrderName(entity.getFoodOrderName());
	            
	            newEntity = foodOrderRepository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = foodOrderRepository.save(entity);
	             
	            return entity;
	        }
	    } 
	 public void deleteFoodOrderById(Long id) throws RecordNotFoundException 
	    {
	        Optional<FoodOrderDeliverySystemModel> foodOrder = foodOrderRepository.findById(id);
	         
	        if(foodOrder.isPresent()) 
	        {
	        	foodOrderRepository.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No employee record exist for given id");
	        }
	    } 
	 
     
	
}
