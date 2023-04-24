package com.training.learning.core.models;

import com.day.cq.search.QueryBuilder;
import com.training.learning.core.services.ImageListService;
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
        adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = ImageListSlingModel.RESOURCE_TYPE
)
public class ImageListSlingModel {

    public final static String RESOURCE_TYPE = "/apps/training/components/ImageListComponent";
    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;
    @ValueMapValue
    private String dampath;

    @OSGiService
    ImageListService imageListService;
    List<String> imagelist = new ArrayList();



    private Session session;

    @PostConstruct
    public void init() throws RepositoryException {
        session=resourceResolver.adaptTo(Session.class);
        imagelist = imageListService.getImagePaths(resourceResolver,dampath,session);
    }

    public String getDampath() {
        return dampath;
    }

    public List<String> getImagelist() {
        return imagelist;
    }

}
