package com.training.learning.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(
        name = "Training Configuration",
        description = "This configuration reads the values to make an HTTP call to a JSON webservice")
public @interface SampleOSGIConfiguration {

    @AttributeDefinition(
            name = "URL",
            description = "This property indicates whether the configuration values will taken into account or not",
            type = AttributeType.STRING)
    public String getUrl() default "https://dummyjson.com/products/1";

    //Checkbox
    @AttributeDefinition(
            name = "Enable config",
            description = "This property indicates whether the configuration values will taken into account or not",
            type = AttributeType.BOOLEAN)
    public boolean enableConfig() default true;

    @AttributeDefinition(name = "MultipleValues", description = "Multi Configuration values")
    String[] getStringValues() default {"1","3","55555"};

    @AttributeDefinition(name = "Password", description = "Password value", type=AttributeType.PASSWORD)
    String password() default "abcd";

    @AttributeDefinition(name = "NumberValue", description = "Number values", type=AttributeType.INTEGER)
    int getNumberValue() default 10;

    @AttributeDefinition( name="Sample Bar",
            options = {
                    @Option(label = "Option Foo", value = "foo"),
                    @Option(label = "Option Bar", value = "bar"),
            }
    )
    String foo_bar() default "bar";


}
