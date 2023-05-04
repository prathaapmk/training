package com.training.learning.core.services.impl;

import com.training.learning.core.config.SampleFieldsOSGIConfiguration;
import com.training.learning.core.services.OSGIService;
import org.json.JSONException;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
@Component(service = OSGIService.class,immediate = true)
@Designate(ocd = com.training.learning.core.config.SampleFieldsOSGIConfiguration.class)

public class OSGIServiceImpl implements OSGIService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String name;

    @Activate @Modified
    public void getAllConfigs(SampleFieldsOSGIConfiguration sampleFieldsOSGIConfiguration)
    {
        name  = sampleFieldsOSGIConfiguration.getName();
        logger.info("OSGI CONFIG Actiavted or Modified"+name);
    }

    @Deactivate
    public void deactiveConfigs(SampleFieldsOSGIConfiguration sampleFieldsOSGIConfiguration)
    {
        name = "";
        logger.info("OSGI CONFIG Deactivated"+name);
    }


    @Override
    public String OSGIService() throws IOException, JSONException {
        return null;
    }

    public String getName() {
        return name;
    }
}
