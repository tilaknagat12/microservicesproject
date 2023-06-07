package com.ms.myntra.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.ms.myntra.config.SampleCodeProperties;
import com.ms.myntra.entity.MyntraSampleRequest;
import com.ms.myntra.entity.MyntraSampleResponse;
import com.ms.myntra.entity.ResponseBean;

@Configuration
@Repository
public class MyntraRepository {

	private SampleCodeProperties properties;

	public MyntraRepository(SampleCodeProperties properties) {
		super();
		this.properties = properties;
	
	}
	
	@Autowired
	RestTemplate resttemplate;
	
	//createorder
	public ResponseBean<MyntraSampleResponse> createProductOrder(MyntraSampleRequest mRequest){
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON); 
	
		
		HttpEntity<?> orderRequest = new HttpEntity<>(mRequest, headers);
		
		ResponseEntity<MyntraSampleResponse> myntraresponse = 
				resttemplate.exchange(properties.getSample().getPosturl(), HttpMethod.POST,orderRequest,MyntraSampleResponse.class);
		
		return ResponseBean.of(myntraresponse.getBody());
	}
	
	//getorder
	public ResponseBean<MyntraSampleResponse> getProductOrder(String id){
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<?> orderrequest = new HttpEntity<>(headers);
		
		ResponseEntity<MyntraSampleResponse> myntraresponse =
				resttemplate.exchange(properties.getSample().getGeturl(), HttpMethod.GET,orderrequest,MyntraSampleResponse.class,id);
	
		return ResponseBean.of(myntraresponse.getBody());  
	
	}
	
	//patchorder
	public ResponseBean<MyntraSampleResponse> patchProductOrder(MyntraSampleRequest response){
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<?> orderrequest = new HttpEntity<>(response, headers);
		
		ResponseEntity<MyntraSampleResponse> myntraresponse =
				resttemplate.exchange(properties.getSample().getPatchurl(), HttpMethod.PATCH,orderrequest,MyntraSampleResponse.class);
	
		return ResponseBean.of(myntraresponse.getBody());
	
	}
	
	//deleteorder
	public ResponseBean<MyntraSampleResponse> deleteProductOrder(MyntraSampleRequest response){
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<?> orderrequest = new HttpEntity<>(response, headers);
		
		ResponseEntity<MyntraSampleResponse> myntraresponse =
				resttemplate.exchange(properties.getSample().getDeleteurl(), HttpMethod.DELETE,orderrequest,MyntraSampleResponse.class);
	
		return ResponseBean.of(myntraresponse.getBody());
	
	}
	
}
