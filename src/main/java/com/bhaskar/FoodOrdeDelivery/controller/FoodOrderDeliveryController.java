package com.bhaskar.FoodOrdeDelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhaskar.FoodOrdeDelivery.Exception.RecordNotFoundException;
import com.bhaskar.FoodOrdeDelivery.model.FoodOrderDeliverySystemModel;
import com.bhaskar.FoodOrdeDelivery.service.FoodOrderDeliverySystemService;

@RestController
@RequestMapping("/foodOrder")
public class FoodOrderDeliveryController {

	@Autowired
	FoodOrderDeliverySystemService service;

	@GetMapping
	public ResponseEntity<List<FoodOrderDeliverySystemModel>> getAllFoodOrders() {
		List<FoodOrderDeliverySystemModel> list = service.getAllFoodOrders();

		return new ResponseEntity<List<FoodOrderDeliverySystemModel>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FoodOrderDeliverySystemModel> getFoodOrderById(@PathVariable("id") Long id)
			throws RecordNotFoundException {
		FoodOrderDeliverySystemModel entity = service.getFoodOrderById(id);

		return new ResponseEntity<FoodOrderDeliverySystemModel>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<FoodOrderDeliverySystemModel> createOrUpdateFoodOrderDelivery(
			FoodOrderDeliverySystemModel foodOrder) throws RecordNotFoundException {
		FoodOrderDeliverySystemModel updated = service.createOrUpdateFoodOrderDelivery(foodOrder);
		return new ResponseEntity<FoodOrderDeliverySystemModel>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteFoodOrderById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteFoodOrderById(id);
		return HttpStatus.FORBIDDEN;
	}

}
