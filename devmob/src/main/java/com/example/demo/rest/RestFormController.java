package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class RestFormController {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//SSL -> https
		//String protocol = "http";
		//int port = 80;
				
		String protocol = "https";
		int port = 443;
		String host = "local.hysolus.com";

        DefaultHttpClient client = new DefaultHttpClient();

        try {
            HttpHost httpHost = new HttpHost(host, port, protocol);
            client.getParams().setParameter(ClientPNames.DEFAULT_HOST, httpHost);
           
            //POST - GET 구분
            HttpPost securedResource = new HttpPost("/Windchill/esolution/rest/post/param1/param2");
            //HttpGet securedResource = new HttpGet("/Windchill/esolution/rest/get/param1/param2");
            
            HttpResponse httpResponse = client.execute(securedResource);
            HttpEntity responseEntity = httpResponse.getEntity();
            String strResponse = EntityUtils.toString(responseEntity);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(responseEntity);

            System.out.println("Http status code for Unauthenticated Request: " + statusCode);// Statue code should be 200
            System.out.println("Response for Unauthenticated Request: \n" + strResponse); // Should be login page
            System.out.println("================================================================\n");

            HttpPost authpost = new HttpPost("/Windchill/j_security_check");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("j_username", "wcadmin"));
            nameValuePairs.add(new BasicNameValuePair("j_password", "wcadmin"));
            authpost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            httpResponse = client.execute(authpost);
            responseEntity = httpResponse.getEntity();
            strResponse = EntityUtils.toString(responseEntity);
            statusCode = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(responseEntity);

            System.out.println("Http status code for Authenticattion Request: " + statusCode);// Status code should be 302
            System.out.println("Response for Authenticattion Request: \n" + strResponse); // Should be blank string
            System.out.println("================================================================\n");

            httpResponse = client.execute(securedResource);
            responseEntity = httpResponse.getEntity();
            strResponse = EntityUtils.toString(responseEntity);
            statusCode = httpResponse.getStatusLine().getStatusCode();
            EntityUtils.consume(responseEntity);

            System.out.println("Http status code for Authenticated Request: " + statusCode);// Status code should be 200
            System.out.println("Response for Authenticated Request: \n" + strResponse);// Should be actual page
            System.out.println("================================================================\n");
        }catch (Exception e) {
            e.printStackTrace();
        }

	}

}
