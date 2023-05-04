package com.training.learning.core.services.impl;

import com.training.learning.core.services.AddNodeToResource;
import org.apache.commons.collections.map.HashedMap;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component(service = AddNodeToResource.class,immediate = true)
public class AddNodeToResourceServiceImpl implements AddNodeToResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Session session;
    @Reference
    ResourceResolverFactory rrf;

    @Override
    public void addNode(Node node) {



        try {

            final Map<String, Object> authInfo = new HashMap<>();
            authInfo.put(ResourceResolverFactory.SUBSERVICE,
                    "testwrite");
            ResourceResolver rr = rrf.getServiceResourceResolver(authInfo);
            session = rr.adaptTo(Session.class);

            logger.info("I am Inside the Service Method");
            //Node node = session.getNode("/content/training/us/en");
            logger.info(">>>>> node.getName() = '{}'", node.getName());
            logger.info(">>>>> node.getPath() = '{}'", node.getPath());
            node.setProperty("practiceDesc", "This is Practice description.");
            logger.info(">>>>  node.getProperty(practiceDesc) = '{}'", node.getProperty("practiceDesc"));
            Node customNode = node.addNode("NodewithSession");
            customNode.setProperty("name", "My FirstName");
            session.save();
            session.logout();
        } catch (PathNotFoundException e) {
            throw new RuntimeException(e);
        } catch (RepositoryException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
    }
}
