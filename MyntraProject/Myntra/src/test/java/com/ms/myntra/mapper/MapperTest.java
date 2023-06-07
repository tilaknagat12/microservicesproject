package com.ms.myntra.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.ms.myntra.entity.MyntraPayload;
import com.ms.myntra.entity.MyntraSampleRequest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class MapperTest {

	@InjectMocks
	Mapper mapper;
	

	static MyntraPayload samplereq ;;
	
	static MyntraSampleRequest newreq ;
	
	@BeforeAll
	public  void init() {
		//payload request
		samplereq = new MyntraPayload();
		samplereq.setAlarm("abc");
		samplereq.setAlarmType("abc");
		samplereq.setClearUserId("abc");
		samplereq.setId("abc");
		samplereq.setNotes("abc");
		
		
		//myntra request
		newreq=new MyntraSampleRequest();
		newreq.setTypeOfAlarm(samplereq.getAlarmType());
		newreq.setComponent(samplereq.getAlarm());
		newreq.setUsername(samplereq.getClearUserId());
		newreq.setIdNumber(samplereq.getId());
		newreq.setNotes(samplereq.getNotes());
		
	}
	 
	@AfterAll
	public  void destroy() {
		samplereq = null;
		newreq = null;
		
	}
	
	@Test
	@DisplayName("Test case for mapper class success scenario")
	public void testapimapping() {
		
		MyntraSampleRequest myntrareq = mapper.apiMapping(samplereq);
		
		Assertions.assertEquals("abc", myntrareq.getNotes());
//		assertEquals(samplereq.getAlarm(),newreq.getComponent());
//		assertEquals(samplereq.getClearUserId(), newreq.getUsername());
//		assertEquals(samplereq.getId(), newreq.getIdNumber());
//		assertEquals(samplereq.getNotes(), newreq.getNotes());
	}
	
	
	
	
}
