package com.training.learning.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

@Model(adaptables = Resource.class)
public class SampleComponentModel {

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String fname;

    @ValueMapValue
    private String dob;

    private String formatedDate;

    @PostConstruct
    public void init()
    {
        try {
            extracted();

        }catch (Exception e)
        {
            System.out.println("Exception");
        }
    }

    private void extracted() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = format.parse(dob);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH");
        formatedDate =format2.format(date);
    }


    public String getText() {
        return text;
    }

    public String getFname() {
        return fname;
    }

    public String getDob() {
        return dob;
    }

    public String getFormatedDate() {
        return formatedDate;
    }
}
