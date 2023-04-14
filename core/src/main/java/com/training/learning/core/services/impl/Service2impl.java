package com.training.learning.core.services.impl;

import com.training.learning.core.services.Service;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Service.class,immediate = true,name = "Service2")
@ServiceRanking(1001)
public class Service2impl implements Service {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void m1() {
        logger.info("I am executing from ServiceImpl:::::::::::::2");
    }
}
