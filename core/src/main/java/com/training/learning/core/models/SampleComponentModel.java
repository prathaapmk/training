package com.training.learning.core.models;

import com.training.learning.core.adapters.SampleComponentAdapter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

@Model(adaptables = SlingHttpServletRequest.class, adapters = SampleComponentAdapter.class,resourceType = "/apps/training/components/samplecomponet")
@Exporter(name = "jackson", extensions = "json")
public class SampleComponentModel implements SampleComponentAdapter{

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @ValueMapValue(name="text")
    private String someText;

    @RequestAttribute
    private String someRandomValue;

    @Self
    SlingHttpServletRequest slingHttpServletRequest;

    @ValueMapValue
    private String fname;

    @ValueMapValue
    private String dob;

    private String formatedDate;

    private String allRequestParamas;

    @PostConstruct
    public void init() {
        try {
            logger.info("Some Random Value" + someRandomValue);
            logger.debug("This is Debug" + someRandomValue);
            extracted();

            allRequestParamas = slingHttpServletRequest.getRequestParameter("q").toString() + slingHttpServletRequest.getRequestParameter("fname");
        } catch (Exception e) {
            logger.error("This is inside exception");
        }
    }

    private void extracted() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date = format.parse(dob);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH");
        formatedDate =format2.format(date);
    }


    @Override
    public String getText() {
        return someText;
    }

    @Override
    public String getFname() {
        return fname;
    }

    @Override
    public String getDob() {
        return dob;
    }

    @Override
    public String getFormatedDate() {
        return formatedDate;
    }

    @Override
    public String getallFeilds() {
        return formatedDate + ""+dob;
    }

    public String getAllRequestParamas() {
        return allRequestParamas;
    }

    public String getSomeRandomValue() {
        return someRandomValue;
    }
}
