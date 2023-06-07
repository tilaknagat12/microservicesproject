package com.ms.myntra.controllertest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.ms.myntra.controller.CodeController;
import com.ms.myntra.entity.MyntraPayload;
import com.ms.myntra.entity.MyntraSampleResponse;
import com.ms.myntra.entity.ResponseBean;
import com.ms.myntra.entity.ResponseBean.ResponseStatus;
import com.ms.myntra.service.MyntraService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerTest {
	
	@InjectMocks
	CodeController controller;
	
	@Mock
	MyntraService msMock;
	
	static MyntraPayload request;
	
	static MyntraSampleResponse response;
	
	
	@BeforeAll
	public static void init() {
//		MockitoAnnotations.openMocks(ControllerTest.class);
		request = new MyntraPayload();
		response = new MyntraSampleResponse();

		response.setProductname("abc");
		response.setRequestdate("date"); 
		request.setAlarm("ADHBVF"); 
		request.setAlarmType("gdf");
		request.setClearUserId("tilak");
		request.setId("1");
		request.setNotes("created");
		
	}
	
	@AfterAll
	public static void destroy() {
		request =null;
		response=null;
		
	}
	
	@Test
	@DisplayName("Test case for post method possitive scenario")
	public void save() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		respo.setData(response); 
		respo.setStatus(ResponseStatus.SUCCESS);
		Mockito.when(msMock.createOrder(request)).thenReturn(respo);
		
		ResponseEntity<?>  res1 = controller.myntracodeservice(request); 
		
		MyntraSampleResponse newres = (MyntraSampleResponse) res1.getBody(); 
		
		Assertions.assertEquals("abc", newres.getProductname());
	}
	
	@Test
	@DisplayName("Test case for post method negative scenario")
	public void negativesave() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		respo.setData(response);
		Mockito.when(msMock.createOrder(request)).thenReturn(respo);
		
		ResponseEntity<?>  res1 = controller.myntracodeservice(request);
		
		Assertions.assertEquals(null, res1);
		
	}
	
	@Test
	@DisplayName("Test case for get method possitive scenario")
	public void get() {
		String Id = "2";
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		respo.setData(response);
		respo.setStatus(ResponseStatus.SUCCESS);
		Mockito.when(msMock.getOrder(Id)).thenReturn(respo);
		
		ResponseEntity<?>  res1 = controller.myntragetservice(Id);
		
		MyntraSampleResponse newres = (MyntraSampleResponse) res1.getBody();
		
		Assertions.assertEquals("2", Id);
	}
	
	@Test
	@DisplayName("Test case for get method negative scenario")
	public void negativeget() {
		String Id = "2";
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		respo.setData(response);
		Mockito.when(msMock.getOrder(Id)).thenReturn(respo);
		
		ResponseEntity<?>  res1 = controller.myntragetservice(Id);

		Assertions.assertEquals(null, res1);
		
	}

	@Test
	@DisplayName("Test case for patch method possitive scenario")
	public void update() {
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		respo.setData(response);
		respo.setStatus(ResponseStatus.SUCCESS);
		Mockito.when(msMock.patchOrder(request)).thenReturn(respo);
		
		ResponseEntity<?>  res1 = controller.myntrapatchservice(request);
		
		MyntraSampleResponse newres = (MyntraSampleResponse) res1.getBody();
		
		Assertions.assertEquals("abc", newres.getProductname());
	}
	@Test
	@DisplayName("Test case for patch method negative scenario")
	public void negativeupdate() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		respo.setData(response);
		Mockito.when(msMock.patchOrder(request)).thenReturn(respo);
		
		ResponseEntity<?>  res1 = controller.myntrapatchservice(request);
		
		Assertions.assertEquals(null, res1);
		
	}
	@Test
	@DisplayName("Test case for delete method possitive scenario")
	public void delete() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		respo.setData(response);
		respo.setStatus(ResponseStatus.SUCCESS);
		Mockito.when(msMock.deleteOrder(request)).thenReturn(respo);
		
		ResponseEntity<?>  res1 = controller.myntradeleteservice(request);
		
		MyntraSampleResponse newres = (MyntraSampleResponse) res1.getBody(); 
		
		Assertions.assertEquals("abc", newres.getProductname()); 
		
	}
	@Test
	@DisplayName("Test case for delete method negative scenario")
	public void negativedelete() {
		
		ResponseBean<MyntraSampleResponse> respo = new ResponseBean<>();
		respo.setData(response);
		Mockito.when(msMock.deleteOrder(request)).thenReturn(respo);
		
		ResponseEntity<?>  res1 = controller.myntradeleteservice(request);
		
		Assertions.assertEquals(null, res1);
		
	}
	
	
	
}
