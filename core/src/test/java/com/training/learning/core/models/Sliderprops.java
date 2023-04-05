package com.training.learning.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import javax.annotation.PostConstruct;
import java.util.List;
@Model(
        adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Sliderprops {

    @ValueMapValue
    private String Slider;

    @ChildResource
    private List<Sliderprops> sliderprops;


    public String getSlider() {
        return Slider;
    }
    public List<Sliderprops> getSliderprops() {
        return sliderprops;
    }
}
