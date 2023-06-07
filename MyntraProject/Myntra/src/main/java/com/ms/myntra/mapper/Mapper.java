package com.ms.myntra.mapper;

import org.springframework.context.annotation.Configuration;

import com.ms.myntra.entity.MyntraPayload;
import com.ms.myntra.entity.MyntraSampleRequest;

@Configuration
public class Mapper {

	public MyntraSampleRequest apiMapping(MyntraPayload request) {
		
		MyntraSampleRequest myReq = new MyntraSampleRequest();
		myReq.setIdNumber(request.getId());
		myReq.setComponent(request.getAlarm());
		myReq.setNotes(request.getNotes());
		myReq.setTypeOfAlarm(request.getAlarmType());
		myReq.setUsername(request.getClearUserId());
		return myReq; 
		
		
	}

	
}
