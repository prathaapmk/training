package com.training.learning.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.annotation.bundle.Export;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = MyFirstSlingModel.RESOURCE_TYPE)
@Exporter(name="jackson",extensions = "json")
public class MyFirstSlingModel {
    public final static String RESOURCE_TYPE = "/apps/training/components/MyFirstSlingModelComponent";
    @ValueMapValue
    private String contactNumber;

    @ValueMapValue
    private String aboutUs;

    @ValueMapValue
    private String corporate;

    @ValueMapValue
    private String moreFromUs;

    @ValueMapValue
    private String sales;

    @ValueMapValue
    private String text;


    @ChildResource
    private List<CountryProps> countryProps;

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public String getCorporate() {
        return corporate;
    }

    public String getMoreFromUs() {
        return moreFromUs;
    }

    public String getSales() {
        return sales;
    }

    public String getText() {
        return text;
    }

    public List<CountryProps> getCountryProps() {
        return countryProps;
    }
}