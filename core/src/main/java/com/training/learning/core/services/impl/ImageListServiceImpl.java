package com.training.learning.core.services.impl;


import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.training.learning.core.services.ImageListService;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(service = ImageListService.class,immediate = true)
public class ImageListServiceImpl implements ImageListService{
    @Reference
    private QueryBuilder builder;

    @Override
    public List<String> getImagePaths(ResourceResolver resourceResolver, String dampath, Session session) throws RepositoryException {
        Map<String, String> predicate = new HashMap<>();
        predicate.put("path", dampath);
        predicate.put("type", "dam:Asset");
        Query query = builder.createQuery(PredicateGroup.create(predicate), session);
        SearchResult searchResult = query.getResult();
        List l = new ArrayList<String>();
        for(Hit hit : searchResult.getHits()) {
            String path = hit.getPath();
            l.add(path);
        }
        return l;
    }
}
