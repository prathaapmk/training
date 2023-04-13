package com.training.learning.core.models;


import com.day.cq.replication.ReplicationActionType;
import com.day.cq.replication.ReplicationException;
import com.day.cq.replication.Replicator;
import com.training.learning.core.services.ReadJsonFromAPIService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.json.JSONException;

import javax.annotation.PostConstruct;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.io.IOException;

@Model(adaptables = SlingHttpServletRequest.class)
public class ReadJsonModelForChecking {


    @SlingObject
    ResourceResolver resourceResolver;
    @OSGiService
    ReadJsonFromAPIService readJsonFromAPIService;
    @PostConstruct
    public void init() throws JSONException, IOException, RepositoryException, ReplicationException {
        String valuesfromApi = readJsonFromAPIService.readJsonfromAPI();
        String datpath ="/content/training/jcr:content";

        Resource r = resourceResolver.getResource(datpath);

        Session session = resourceResolver.adaptTo(Session.class);
        Node node = session.getNode(r.getPath());
        Node customNode = node.addNode("data");
        customNode.setProperty("jsonData",valuesfromApi);
        session.save();
        session.logout();

    }
}
