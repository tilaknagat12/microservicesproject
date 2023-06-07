package com.ms.myntra.repotest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ms.myntra.config.SampleCodeProperties;
import com.ms.myntra.config.SampleCodeProperties.Sample;
import com.ms.myntra.entity.MyntraSampleRequest;
import com.ms.myntra.entity.MyntraSampleResponse;
import com.ms.myntra.entity.ResponseBean;
import com.ms.myntra.mapper.Mapper;
import com.ms.myntra.repository.MyntraRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class RepoTest {
	
	@InjectMocks
	MyntraRepository mrepo;
	
	@Mock
	RestTemplate tempmocker;
	
	
	
	@Mock
	SampleCodeProperties properties = new SampleCodeProperties();
	
	static MyntraSampleRequest msreq;
	
	static ResponseBean<MyntraSampleResponse> response;
	
	static MyntraSampleResponse res;
	
	static HttpHeaders reqheader;
	
	static HttpEntity<?> entity;
	
	static ResponseEntity<MyntraSampleResponse> respoentity;
	
	static Sample sample;
	{
		sample=properties.create();
		properties.setSample(sample);
		sample.setPosturl("http://localhost:8089/myntra/createorder");
		sample.setGeturl("http://localhost:8089/myntra/getorder/{id}");
		sample.setPatchurl("http://localhost:8089/myntra/updateorder");
		sample.setDeleteurl("http://localhost:8089/myntra/deleteorder");
		
	}
	
	@BeforeAll
	public void init() {
		
		//myntra request
		msreq = new MyntraSampleRequest();
		msreq.setTypeOfAlarm("created");
		msreq.setComponent("abc");
		msreq.setUsername("tilak");
		msreq.setIdNumber("1");
		msreq.setNotes("alarm for create method");
		
		
		
		//myntra response
		res=new MyntraSampleResponse();
		res.setProductname("cable");
		res.setRequestdate("02/05/2020");
		
		
		//creating headers
		reqheader=new HttpHeaders();
		reqheader.setContentType(MediaType.APPLICATION_JSON);
		
		entity=new HttpEntity<>(msreq,reqheader);
		
		
		//creating response entity
		respoentity=new ResponseEntity<>(res,HttpStatus.OK);	
	}
	
	@AfterAll
	public static void detroy() {
		msreq=null;
		response=null;
		res=null;
	}

	@BeforeEach
	public void set() {
		Mockito.when(properties.getSample()).thenReturn(sample);
	}
	
	@Test
	@DisplayName("Test case for create method success scenario")
	public void create() {
		Mockito.when(tempmocker.exchange(properties.getSample().getPosturl(),HttpMethod.POST,entity,MyntraSampleResponse.class)).thenReturn(respoentity);
		ResponseBean<MyntraSampleResponse> res1= mrepo.createProductOrder(msreq);
		
		Assertions.assertEquals("cable", res1.getData().getProductname());
	
	}
	
	
	@Test
	@DisplayName("Test case for get method success scenario")
	public void get() {
		String Id="2";
		Mockito.when(tempmocker.exchange(properties.getSample().getGeturl(),HttpMethod.GET,entity,MyntraSampleResponse.class,Id)).thenReturn(respoentity);
		ResponseBean<MyntraSampleResponse> res1= mrepo.getProductOrder(Id);
		
		Assertions.assertEquals("cable", res1.getData().getProductname());
	
	}
	
	@Test
	@DisplayName("Test case for patch method success scenario")
	public void update() {
		Mockito.when(tempmocker.exchange(properties.getSample().getPatchurl(),HttpMethod.PATCH,entity,MyntraSampleResponse.class)).thenReturn(respoentity);
		ResponseBean<MyntraSampleResponse> res1= mrepo.patchProductOrder(msreq);
		
		Assertions.assertEquals("cable", res1.getData().getProductname());
	
	}
	
	
	@Test
	@DisplayName("Test case for patch method success scenario")
	public void delete() {
		Mockito.when(tempmocker.exchange(properties.getSample().getDeleteurl(),HttpMethod.DELETE,entity,MyntraSampleResponse.class)).thenReturn(respoentity);
		ResponseBean<MyntraSampleResponse> res1= mrepo.deleteProductOrder(msreq);
		
		Assertions.assertEquals("cable", res1.getData().getProductname());
	
	}
	
	
}
