package com.training.learning.core.services.impl;

import com.training.learning.core.config.SampleOSGIConfiguration;
import com.training.learning.core.services.ReadJsonFromAPIService;
import com.training.learning.core.services.Service;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


@Component(service = ReadJsonFromAPIService.class,immediate = true)
@Designate(ocd = com.training.learning.core.config.SampleOSGIConfiguration.class)
public class ReadJsonFromAPIServiceImpl implements ReadJsonFromAPIService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(target = "(component.name=service1)")
    Service service1;

    @Reference(target = "(component.name=Service2)")
    Service service2;

    private String url;

    @Activate @Modified
    public void getAllConfigs(SampleOSGIConfiguration sampleOSGIConfiguration)
    {
        url = sampleOSGIConfiguration.getUrl();
        logger.info("OSGI CONFIG Actiavted or Modified"+url);
    }

    @Deactivate
    public void deactiveConfigs(SampleOSGIConfiguration sampleOSGIConfiguration)
    {
        url = "";
        logger.info("OSGI CONFIG Deactivated"+url);
    }

    @Override
    public String readJsonfromAPI() throws JSONException {
        try {
           service1.m1();
           service2.m1();
            String urlString = getUrl();
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            // Parse the JSON response
            JSONObject json = new JSONObject(response.toString());
            return json.toString();

        } catch (IOException | JSONException e) {
            logger.error("Exception throwed while retriving the Data");
            /*String dummyString ="{}";
            JSONObject json2 = new JSONObject(dummyString.toString());*/
            return "json2";
        }

    }

    public String getUrl() {
        return url;
    }
}
