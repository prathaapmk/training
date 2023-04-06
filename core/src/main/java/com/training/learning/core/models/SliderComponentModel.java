package com.training.learning.core.models;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.Resource;

@Model(
        adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = SliderComponentModel.RESOURCE_TYPE,cache = true
)
@Exporter(name="jackson",extensions = "json")
public class SliderComponentModel {

    public final static String RESOURCE_TYPE = "/apps/training/components/slider";

    @ValueMapValue
    private String[] Slider;


    public String[] getSlider() {
        return Slider;
    }
}
