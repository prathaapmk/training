package com.training.learning.core.models;

import com.training.learning.core.services.ConvertFilereferenceToImageTitle;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageModel {

    @OSGiService
    ConvertFilereferenceToImageTitle convertFilereferenceToImageTitle;

    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;

    @ValueMapValue
    private String[] referencearray;

    List<String> list = new ArrayList();


    @PostConstruct
    protected void init() {

        if(referencearray != null) {
            list = convertFilereferenceToImageTitle.pathToTitleMethod(referencearray,resourceResolver,currentResource);
        }
    }

    public List<String> getList() {
        return list;
    }

}
