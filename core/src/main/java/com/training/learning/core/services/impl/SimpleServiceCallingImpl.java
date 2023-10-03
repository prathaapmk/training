package com.training.learning.core.services.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.training.learning.core.services.SampleInterface;
import com.training.learning.core.services.SimpleServiceForCallingService;

@Component(service = SimpleServiceForCallingService.class)
public class SimpleServiceCallingImpl implements SimpleServiceForCallingService{

	@Reference(target = "(component.name=b5-1)")
	SampleInterface smi;
	
	@Override
	public String callaSpecificService() {
		// TODO Auto-generated method stub
		return smi.retrunSomeName();
	}

}
