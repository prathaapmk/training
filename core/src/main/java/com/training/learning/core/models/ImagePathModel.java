package com.training.learning.core.models;

import com.day.cq.search.QueryBuilder;
import com.training.learning.core.services.ImagePathService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Reference;
import javax.annotation.PostConstruct;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.List;

@Model(
        adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = ImagePathModel.RESOURCE_TYPE
)
public class ImagePathModel {

    public final static String RESOURCE_TYPE = "/apps/training/components/imagePath";
    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;
    @ValueMapValue
    private String imagePath;

    @OSGiService
    ImagePathService imagePathService;
    List<String> imagelist = new ArrayList();


    private Session session;

    @PostConstruct
    public void init()
    {
        session=resourceResolver.adaptTo(Session.class);
        try {
            imagelist = imagePathService.getImagePaths(resourceResolver,imagePath,session);
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
    }

    public String getImagePath() {
        return imagePath;
    }

    public List<String> getImagelist() {
        return imagelist;
    }

}
