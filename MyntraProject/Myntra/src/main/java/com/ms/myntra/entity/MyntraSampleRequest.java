package com.ms.myntra.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyntraSampleRequest {
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String TypeOfAlarm;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String component;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String username;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String idNumber;
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String Notes;
	
	
	
}
