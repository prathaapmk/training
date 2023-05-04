package com.training.learning.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.training.learning.core.services.AddNodeToResource;
import com.training.learning.core.services.ReadJsonFromAPIService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.apache.sling.models.factory.ModelFactory;
import org.json.JSONException;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Model(
        adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = MultiFieldComponentModel.RESOURCE_TYPE
)
@Exporter(name="jackson",extensions = "json")
public class MultiFieldComponentModel {


    public final static String RESOURCE_TYPE = "/apps/training/components/multifieldcomponent";
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;
   /*     @Self
        Page page;*/

    @ValueMapValue
    private String[] studentName;
    @OSGiService
    SlingHttpServletRequest req;

    @OSGiService
    AddNodeToResource addNodeToResource ;

    @OSGiService
    ReadJsonFromAPIService readJsonFromAPIService;

    @ChildResource
    private List<CountryProps> countryProps;
    private boolean valuChaced;

    @PostConstruct
    public void init()
    {  try {
        readJsonFromAPIService.readJsonfromAPI();
        Session session = resourceResolver.adaptTo(Session.class);
        Node node = session.getNode(currentResource.getPath());
        addNodeToResource.addNode(node);
        }catch (PathNotFoundException e) {
            throw new RuntimeException(e);
        }  catch (RepositoryException e) {
            e.printStackTrace();
        } catch (JSONException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
        String str = "/content/training/us/en";
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
       // CountryProps pp = resourceResolver.adaptTo(CountryProps.class);
        //String title = page.getTitle();
        String node = currentResource.getName();
        String currentResourcePath = currentResource.getPath();
        Resource parent = currentResource.getParent();
        String parentName = parent.getName();
        String currentPagePath = Optional.ofNullable(pageManager)
                .map(pm -> pm.getContainingPage(currentResource))
                .map(Page::getPath).orElse("");

       // logger.info("title::::::::::"+title);
        logger.info("currentResourcePath::::::::::"+currentResourcePath);
        logger.info("node::::::::::"+node);
        logger.info("parent::::::::::"+parent);
        logger.info("parentName:::::::"+parentName);
        logger.info("currentPagePath"+currentPagePath);
    }
    public String[] getStudentName() {

    return studentName;
    }

    public List<CountryProps> getCountryProps() {

    return countryProps;
    }

}
