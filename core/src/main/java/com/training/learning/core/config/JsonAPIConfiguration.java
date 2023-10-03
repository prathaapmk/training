package com.training.learning.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Training JSON Configuration",
        description = "This JSON configuration reads the values to make an HTTP call to a JSON webservice")
public @interface JsonAPIConfiguration {
	
	  @AttributeDefinition(
	            name = "jsonapi",
	            description = "This property indicates whether the configuration values will taken into account or not",
	            type = AttributeType.STRING)
	    public String getJsonApi() default "https://dummyjson.com/products/1";

}
