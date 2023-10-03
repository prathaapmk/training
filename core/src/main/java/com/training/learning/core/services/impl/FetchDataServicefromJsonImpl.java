package com.training.learning.core.services.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.training.learning.core.services.FetchDataServicefromJson;
import com.training.learning.core.services.ReadJsonAPIService;

@Component(service = FetchDataServicefromJson.class,immediate = true)
public class FetchDataServicefromJsonImpl implements FetchDataServicefromJson{

	@Reference
	ReadJsonAPIService rjas;
	
	@Override
	public String fetchDatafromJsonApi() {
		// TODO Auto-generated method stub
		StringBuffer responseStr = new StringBuffer();
		try {
		String url = rjas.readJsonAPIURL();
		
		URL urlForGetReq = new URL(url);  
		String read = null;  
		HttpURLConnection connection = (HttpURLConnection) urlForGetReq.openConnection();  
		connection.setRequestMethod("GET");   
		int codeResponse = connection.getResponseCode();  
		// checking whether the connection has been established or not  
		if (codeResponse == HttpURLConnection.HTTP_OK)   
		{  
		// reading the response from the server  
		InputStreamReader isrObj = new InputStreamReader(connection.getInputStream());  
		BufferedReader bf = new BufferedReader(isrObj);  
		// to store the response from the servers  
		  
		while ((read = bf .readLine()) != null)  
		{  
		    responseStr.append(read);  
		}   
		// closing the BufferedReader  
		bf.close();  
		// disconnecting the connection  
		connection.disconnect();  
		// print the response  
		System.out.println("JSON String Result is: \n" + responseStr.toString()); 
		
		}   
		else   
		{  
		    System.out.println("GET Request did not work");  
			return "nothing";
		}  
	
		}catch (Exception e) {
			// TODO: handle exception
			return "nothing";
		}
		return responseStr.toString();
		
	}

}
