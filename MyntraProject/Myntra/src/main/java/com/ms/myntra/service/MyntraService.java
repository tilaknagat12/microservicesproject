package com.ms.myntra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.myntra.entity.MyntraPayload;
import com.ms.myntra.entity.MyntraSampleRequest;
import com.ms.myntra.entity.MyntraSampleResponse;
import com.ms.myntra.entity.ResponseBean;
import com.ms.myntra.mapper.Mapper;
import com.ms.myntra.repository.MyntraRepository;

@Service
public class MyntraService {
	
	@Autowired
	MyntraRepository myntrarepo;
	
	@Autowired
	Mapper map;
	
	
	//createorder
	public ResponseBean<MyntraSampleResponse> createOrder(MyntraPayload request){
		
	
		MyntraSampleRequest myReq = new MyntraSampleRequest();
		myReq = map.apiMapping(request);
		
		ResponseBean<MyntraSampleResponse> res = myntrarepo.createProductOrder(myReq);
		
		if(res.isSuccess()) {
			return res;
		}else {
			return ResponseBean.errorRes("400","BadRequest"); 
		}
	}
	
	//getorder
	public ResponseBean<MyntraSampleResponse> getOrder(String id){
		ResponseBean<MyntraSampleResponse> res = myntrarepo.getProductOrder(id);
		
		if(res.isSuccess()) {
			return res;
		}else {
			return ResponseBean.errorRes("400","BadRequest"); 
		}
	}
	
	//patchorder
	public ResponseBean<MyntraSampleResponse> patchOrder(MyntraPayload request){
		

		MyntraSampleRequest myReq = new MyntraSampleRequest();
		myReq = map.apiMapping(request);
		ResponseBean<MyntraSampleResponse> res = myntrarepo.patchProductOrder(myReq);
		
		if(res.isSuccess()) {
			return res;
		}else {
			return ResponseBean.errorRes("400","BadRequest");
		}
	}
	
	//deleteorder
		public ResponseBean<MyntraSampleResponse> deleteOrder(MyntraPayload request){
			

			MyntraSampleRequest myReq = new MyntraSampleRequest();
			myReq = map.apiMapping(request);
			ResponseBean<MyntraSampleResponse> res = myntrarepo.deleteProductOrder(myReq);
			
			if(res.isSuccess()) {
				return res;
			}else {
				return ResponseBean.errorRes("400","BadRequest"); 
			}
		}
	
}
