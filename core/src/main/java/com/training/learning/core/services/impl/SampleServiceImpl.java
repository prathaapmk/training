package com.training.learning.core.services.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;

import com.training.learning.core.services.SampleInterface;

@Component(service = SampleInterface.class,immediate = true,name = "b5-1")
//@ServiceRanking(2000)
public class SampleServiceImpl implements SampleInterface{

	@Override
	public String retrunSomeName() {
		// TODO Auto-generated method stub
		
		return "SampleServiceImpl 1";
	}

}
