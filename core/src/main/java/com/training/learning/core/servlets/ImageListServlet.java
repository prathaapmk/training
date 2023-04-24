package com.training.learning.core.servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Session;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;

@Component(service = Servlet.class, property = {Constants.SERVICE_DESCRIPTION + "=Query Builder servlet",
        "sling.servlet.methods=" + "GET",
        "sling.servlet.paths=" + "/bin/training/test",
        "sling.servlet.resourceTypes="+"training/components/dampathcomponent",
        "sling.servlet.extensions=" + "txt"
})
public class ImageListServlet extends SlingSafeMethodsServlet {

    @Reference
    private QueryBuilder builder;

    private Session session;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

        try {
            String param = request.getParameter("param");
            ResourceResolver resourceResolver = request.getResourceResolver();
            session = resourceResolver.adaptTo(Session.class);
            Map<String, String> predicate = new HashMap<>();
            predicate.put("path", "/content/dam");
            predicate.put("type", "dam:Asset");
            Query query = builder.createQuery(PredicateGroup.create(predicate), session);
            SearchResult searchResult = query.getResult();
            List l = new ArrayList<String>();
            for(Hit hit : searchResult.getHits()) {

                String path = hit.getPath();
                l.add(path);
            }
        } catch (Exception e) {

            e.getMessage();
        } finally {

            if(session != null) {

                session.logout();
            }
        }
    }

}
