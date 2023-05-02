package com.training.learning.core.services;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import java.util.ArrayList;
import java.util.List;

public interface ConvertFilereferenceToImageTitle {

    public ArrayList<String> pathToTitleMethod(String[] arrayName, ResourceResolver resourceResolver, Resource currentResource);


}
