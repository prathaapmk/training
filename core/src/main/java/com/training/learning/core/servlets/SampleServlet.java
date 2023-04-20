package com.training.learning.core.servlets;

import com.training.learning.core.services.ReadJsonFromAPIService;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.json.JSONException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class, property={
        "sling.servlet.methods=" + "GET",
        "sling.servlet.paths="+ "/bin/training/test",
        "sling.servlet.resourceTypes="+"training/components/ajaxbutton",
        "sling.servlet.extensions=" + "txt"
})
@ServiceDescription("Sample Demo Servlet")
public class SampleServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Reference
    ReadJsonFromAPIService readJsonFromAPIService;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws IOException {

        String json= StringUtils.EMPTY;
        try {
         json=    readJsonFromAPIService.readJsonfromAPI();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
       // final String str = "This is Demo Servlet";
        resp.setContentType("text/plain");
        resp.getWriter().write(json);
    }


}
