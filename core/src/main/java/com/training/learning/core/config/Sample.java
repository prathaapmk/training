package com.training.learning.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition( name = "Training Sample Configuration",
        description = "This Sample configuration reads the values to make an HTTP call to a JSON webservice")
public @interface Sample {
	
	@AttributeDefinition(name = "payment",
            description = "This property indicates whether the configuration values will taken into account or not",
            type = AttributeType.STRING)
	public String paymentInfo() default "https://www.payment.getinfo.com";

}
