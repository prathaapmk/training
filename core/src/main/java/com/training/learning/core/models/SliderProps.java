package com.training.learning.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import java.util.List;
@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SliderProps {

    @ValueMapValue
    private String Slider;

    @ChildResource
    private List<SliderProps> sliderProps;

    public String getSlider() {
        return Slider;
    }

    public List<SliderProps> getSliderProps() {
        return sliderProps;
    }
}

