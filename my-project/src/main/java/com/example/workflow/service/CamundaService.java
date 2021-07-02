package com.example.workflow.service;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamundaService {
	
	@Autowired
	RuntimeService runtimeService;
	
	public void startProcessBySendingId(String customerName) {
		runtimeService.createMessageCorrelation("message").setVariable("customerName", customerName).correlate();
	}

}
