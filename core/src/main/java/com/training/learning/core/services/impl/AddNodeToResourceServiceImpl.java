package com.training.learning.core.services.impl;

import com.training.learning.core.services.AddNodeToResource;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

@Component(service = AddNodeToResource.class,immediate = true)
public class AddNodeToResourceServiceImpl implements AddNodeToResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void addNode(Session session, Node node) {

        try {
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
        }
    }
}