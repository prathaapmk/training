package com.training.learning.core.services;

import com.day.cq.search.QueryBuilder;
import org.apache.sling.api.resource.ResourceResolver;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.List;

public interface ImageListService {

    List<String> getImagePaths(ResourceResolver resourceResolver, String dampath, Session session) throws RepositoryException;
}