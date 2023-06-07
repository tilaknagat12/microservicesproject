package com.ms.myntra.servicetest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.ms.myntra.entity.MyntraPayload;
import com.ms.myntra.entity.MyntraSampleRequest;
import com.ms.myntra.entity.MyntraSampleResponse;
import com.ms.myntra.entity.ResponseBean;
import com.ms.myntra.entity.ResponseBean.ResponseStatus;
import com.ms.myntra.mapper.Mapper;
import com.ms.myntra.repository.MyntraRepository;
import com.ms.myntra.service.MyntraService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ServiceTest {


	@InjectMocks
	MyntraService service;

	@Mock
	MyntraRepository mocker;
	
	@Mock
	Mapper mappermock;
	
	
	static MyntraPayload request;
	
	static MyntraSampleResponse response;
	
	static MyntraSampleRequest msr;
	
	
	@BeforeAll
	public static void init() {
		
		//client request
		request = new MyntraPayload();             
		request.setAlarm("post");
		request.setAlarmType("created");
		request.setClearUserId("tilak");
		request.setId("1");
		request.setNotes("creating");
		
		//myntra request
		msr = new MyntraSampleRequest();
		msr.setTypeOfAlarm(request.getAlarmType());
		msr.setComponent(request.getAlarm());
		msr.setUsername(request.getClearUserId());
		msr.setIdNumber(request.getId());
		msr.setNotes(request.getNotes());
		
		//myntra response
		response = new MyntraSampleResponse();
		response.setProductname("earpods");
		response.setRequestdate("02/05/2021");
		
		
	}
	
	@AfterAll
	public static void teardown() {
		request=null;
		msr =null;
		response=null;
	}
	
	
	@Test
	@DisplayName("Test case for create method success scenario")
	public void create() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		
		respo.setData(response);
		respo.setStatus(ResponseStatus.SUCCESS);
		
		Mockito.when(mappermock.apiMapping(request)).thenReturn(msr); 
		
		Mockito.when(mocker.createProductOrder(msr)).thenReturn(respo);
		
		ResponseBean<MyntraSampleResponse> res1= service.createOrder(request);
		
		Assertions.assertEquals("earpods", res1.getData().getProductname());
		
	}
	
	
	@Test
	@DisplayName("Test case for create method negative scenario")
	public void negativecreate() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		
		Mockito.when(mappermock.apiMapping(request)).thenReturn(msr);
		
		Mockito.when(mocker.createProductOrder(msr)).thenReturn(respo);
		
		ResponseBean<MyntraSampleResponse> res1= service.createOrder(request);
		
		Assertions.assertEquals(ResponseStatus.FAILURE,res1.getStatus());
		
	}
	
	@Test
	@DisplayName("Test case for get method success scenario")
	public void get() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		String Id="2";
		respo.setData(response);
		respo.setStatus(ResponseStatus.SUCCESS);
		
		Mockito.when(mappermock.apiMapping(request)).thenReturn(msr);
		
		Mockito.when(mocker.getProductOrder(Id)).thenReturn(respo);
		
		ResponseBean<MyntraSampleResponse> res1= service.getOrder(Id);
		
		Assertions.assertEquals("earpods", res1.getData().getProductname());
		
	}
	
	@Test
	@DisplayName("Test case for get method negative scenario")
	public void Negativeget() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		String Id="2";
		respo.setData(response);
		
		Mockito.when(mappermock.apiMapping(request)).thenReturn(msr);
		
		Mockito.when(mocker.getProductOrder(Id)).thenReturn(respo);
		
		ResponseBean<MyntraSampleResponse> res1= service.getOrder(Id);
		
		Assertions.assertEquals(ResponseStatus.FAILURE,res1.getStatus());
		
	}
	
	@Test
	@DisplayName("Test case for patch method success scenario")
	public void update() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		
		respo.setData(response);
		respo.setStatus(ResponseStatus.SUCCESS);
		
		Mockito.when(mappermock.apiMapping(request)).thenReturn(msr);
		
		Mockito.when(mocker.patchProductOrder(msr)).thenReturn(respo);
		
		ResponseBean<MyntraSampleResponse> res1= service.patchOrder(request);
		
		Assertions.assertEquals("earpods", res1.getData().getProductname());
		
	}
	
	@Test
	@DisplayName("Test case for patch method negative scenario")
	public void negativeupdate() {
		
        ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		
		respo.setData(response);
		
		Mockito.when(mappermock.apiMapping(request)).thenReturn(msr);
		
		Mockito.when(mocker.patchProductOrder(msr)).thenReturn(respo);
		
		ResponseBean<MyntraSampleResponse> res1= service.patchOrder(request);
		
		Assertions.assertEquals(ResponseStatus.FAILURE,res1.getStatus());
		
	}
	
	@Test
	@DisplayName("Test case for delete method success scenario")
	public void delete() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		
		respo.setData(response);
		respo.setStatus(ResponseStatus.SUCCESS);
		
		Mockito.when(mappermock.apiMapping(request)).thenReturn(msr);
		
		Mockito.when(mocker.deleteProductOrder(msr)).thenReturn(respo);
		
		ResponseBean<MyntraSampleResponse> res1= service.deleteOrder(request);
		
		Assertions.assertEquals("earpods", res1.getData().getProductname());
		
	}
	
	@Test
	@DisplayName("Test case for delete method success scenario")
	public void Negativedelete() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		
		respo.setData(response);
		
		Mockito.when(mappermock.apiMapping(request)).thenReturn(msr);
		
		Mockito.when(mocker.deleteProductOrder(msr)).thenReturn(respo);
		
		ResponseBean<MyntraSampleResponse> res1= service.deleteOrder(request);
		
		Assertions.assertEquals(ResponseStatus.FAILURE,res1.getStatus());
		
	}
	
}
