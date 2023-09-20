package com.training.learning.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MyFirstSlingModel {
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
   private  String text;

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
}