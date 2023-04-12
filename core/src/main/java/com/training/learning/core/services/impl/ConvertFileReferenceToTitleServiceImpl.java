package com.training.learning.core.services.impl;

import com.training.learning.core.services.ConvertFilereferenceToImageTitle;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

@Component(service=ConvertFilereferenceToImageTitle.class,immediate = true)
public class ConvertFileReferenceToTitleServiceImpl implements ConvertFilereferenceToImageTitle {


    List<String> alist = new ArrayList();


    @Override
    public ArrayList<String> pathToTitleMethod(String[] arrayName, ResourceResolver resourceResolver, Resource currentResource) {
        for (int i = 0; i < arrayName.length; i++) {
            Resource resource = resourceResolver.getResource(arrayName[i]+"/jcr:content");
            ValueMap properties = resource.getValueMap();

            String pageTitle = properties.get("jcr:title", String.class);

            alist.add(pageTitle);

        }
        return (ArrayList<String>) alist;



    }
}
