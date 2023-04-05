package com.training.learning.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.List;

@Model(
        adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = MultiFieldComponentModel.RESOURCE_TYPE,cache = true
)
@Exporter(name="jackson",extensions = "json")
public class MultiFieldComponentModel {

    public final static String RESOURCE_TYPE = "/apps/training/components/multifieldcomponent";

    @ValueMapValue
    private String[] studentName;

    @ChildResource
    private List<CountryProps> countryProps;


    public String[] getStudentName() {
        return studentName;
    }

    public List<CountryProps> getCountryProps() {
        return countryProps;
    }
}
