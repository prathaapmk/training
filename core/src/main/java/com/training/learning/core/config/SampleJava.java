package com.training.learning.core.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SampleJava {

	public static void main(String[] args) {
		
		try {
			//String url = rjas.readJsonAPIURL();
			StringBuffer responseStr = new StringBuffer();

			URL urlForGetReq = new URL("https://dummyjson.com/products/1");  
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
		
			}catch (Exception e) {
				// TODO: handle exception
			//	return "nothing";
			}
	//		return responseStr.toString();
	}
}
