package com.training.learning.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import com.training.learning.core.config.JsonAPIConfiguration;
import com.training.learning.core.services.ReadJsonAPIService;

@Component(service = ReadJsonAPIService.class,immediate = true)
@Designate(ocd=JsonAPIConfiguration.class)
public class ReadJsonAPIServiceImpl implements ReadJsonAPIService{

	private String getjsonulr;
	
	@Activate
	@Modified
	public void getAPIs( JsonAPIConfiguration json)
	{
		
		getjsonulr = json.getJsonApi();
	}

	@Override
	public String readJsonAPIURL() {
		// TODO Auto-generated method stub
		return getjsonulr;
	}
	
	
	
	

}
