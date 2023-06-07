package com.ms.myntra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.myntra.entity.MyntraPayload;
import com.ms.myntra.entity.MyntraSampleResponse;
import com.ms.myntra.entity.ResponseBean;
import com.ms.myntra.service.MyntraService;

@RestController
@RequestMapping("/myntra-page")
@CrossOrigin
public class CodeController {
	
	@Autowired
	MyntraService service;
	
	
	@PostMapping(value = "/order-creation", produces={MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> myntracodeservice(
			@RequestBody MyntraPayload myntrareq){
		ResponseBean<MyntraSampleResponse> response = service.createOrder(myntrareq);

		if(response.isSuccess()) {
			return new ResponseEntity<>(response.getData(),HttpStatus.CREATED);
		}else {
			return null;                                                        
		}
		
}
	
	
	@GetMapping(value = "/order-status/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> myntragetservice(  @PathVariable String id){
		ResponseBean<MyntraSampleResponse> response = service.getOrder(id);
		if(response.isSuccess()) { 
			return new ResponseEntity<>(response.getData(),HttpStatus.CREATED);
		}else {
			return null;
		}	
	}
	
	@PatchMapping(value = "/order-updation", produces={MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> myntrapatchservice(
			@RequestBody MyntraPayload myntrareq){

		ResponseBean<MyntraSampleResponse> response = service.patchOrder(myntrareq); 
		if(response.isSuccess()) {
			return new ResponseEntity<>(response.getData(),HttpStatus.CREATED);
		}else {
			return null;
		}	
	}
	
	
	@DeleteMapping(value = "/order-deletion", produces={MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> myntradeleteservice(
			@RequestBody MyntraPayload myntrareq){
		
		ResponseBean<MyntraSampleResponse> response = service.deleteOrder(myntrareq);
		if(response.isSuccess()) {
			return new ResponseEntity<>(response.getData(),HttpStatus.CREATED);
		}else {
			return null;
		}	
	}
		
}

