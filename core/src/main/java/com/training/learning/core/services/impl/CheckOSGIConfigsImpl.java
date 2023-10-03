package com.training.learning.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import com.training.learning.core.config.Sample;
import com.training.learning.core.services.CheckOSGIConfigs;

@Component(service = CheckOSGIConfigs.class,immediate = true)
@Designate(ocd=com.training.learning.core.config.Sample.class)
public class CheckOSGIConfigsImpl implements CheckOSGIConfigs{
	
	private String paymentURL;
	
	@Activate @Modified
	public void getConf(Sample sample)
	{
		paymentURL =sample.paymentInfo();
	}
	
	@Deactivate
	
	public void removeConf(Sample sample)
	{
		paymentURL ="";
	}

	public String getPaymentURL() {
		return paymentURL;
	}

	@Override
	public String readOSGI() {
		// TODO Auto-generated method stub
		return paymentURL;
	}

	
	
}
