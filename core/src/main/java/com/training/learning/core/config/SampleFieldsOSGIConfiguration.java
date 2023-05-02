package com.training.learning.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(
        name = "Training Sample Configuration",
        description = "This configuration reads the values to make an HTTP call to a JSON webservice")
public @interface SampleFieldsOSGIConfiguration {

    @AttributeDefinition(name = "Name", description = "Please provide your name", type = AttributeType.STRING)
    public String getName() default "Sairam";

    @AttributeDefinition(name = "Country", description = "Please provide country name", type = AttributeType.STRING)
    public String getCountry() default "India";

    @AttributeDefinition(name = "Currency", description = "Please provide country's currency", type = AttributeType.STRING)
    public String getCurrency() default "Rupee";

    @AttributeDefinition(name = "Password", description = "Please provide Password", type = AttributeType.PASSWORD)
    public String getPassword();

}
