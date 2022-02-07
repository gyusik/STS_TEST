package com.example.demo.rest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestBasicController {
	
	@RequestMapping("/sendGET") 
	public String sendGET(@RequestParam Map<String, Object> reqMap) throws IllegalStateException {
        String inputLine = null;
        StringBuffer outResult = new StringBuffer();
        String stringUrl = "http://local.hysolus.com/Windchill/esolution/rest/";
        try {
            System.out.println("HTTP API Start -----");
            reqMap.entrySet().forEach((entry) -> System.out.println(
        	        "key: " + entry.getKey() + ", value: " + entry.getValue()));
            
            String oid = (String) reqMap.get("oid");
			String sendUrl = (String) reqMap.get("sendUrl");
			String param1 = (String) reqMap.get("param1");
			String param2 = (String) reqMap.get("param2");
			if(param1.length() > 0 ) {
				param1 = "/"+param1;
			}
			if(param2.length() > 0 ) {
				param2 = "/"+param2;
			}
			
			System.out.println("sendUrl -> "+stringUrl+sendUrl+param1+param2);
			 
            URL url = new URL(stringUrl+sendUrl+param1+param2);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            //GET
            conn.setRequestMethod("GET");
            
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            
            
            /****** Basic 인증 *****/
            String id_pass = "wcadmin:wcadmin";
            String base64Credentials = new String(Base64.getEncoder().encode(id_pass.getBytes()));
            conn.setRequestProperty("Authorization", "Basic " + base64Credentials);
           
            /******           *****/
            
            // 리턴된 결과 읽기
            BufferedReader in = new BufferedReader(
            		new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((inputLine = in.readLine()) != null) {
                outResult.append(inputLine+"\n");
            }
            
            conn.disconnect();
            System.out.println("outResult.toString() -> "+outResult.toString());
            System.out.println("HTTP API End -----");
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return outResult.toString();
    }
	
	@RequestMapping("/sendPOST") 
	public String sendPOST(@RequestBody Map<String, Object> reqMap) throws IllegalStateException {
        String inputLine = null;
        StringBuffer outResult = new StringBuffer();
        String stringUrl = "http://local.hysolus.com/Windchill/esolution/rest/";
        try {
            System.out.println("HTTP API Start -----");
            
            StringBuilder postData = new StringBuilder();
            for (Entry<String, Object> param : reqMap.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
//            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
            System.out.println("postData => "+postData.toString());
            
            
            String oid = (String) reqMap.get("oid");
			String sendUrl = (String) reqMap.get("sendUrl");
			String param1 = (String) reqMap.get("param1");
			String param2 = (String) reqMap.get("param2");
			if(param1 !=null && param1.length() > 0 ) {
				param1 = "/"+param1;
			}else {
				param1 = "/nodata";
			}
			
			if(param2 !=null && param2.length() > 0 ) {
				param2 = "/"+param2;
			}else {
				param2 = "/nodata";
			}
			
			System.out.println("sendUrl -> "+stringUrl+sendUrl+param1+param2);
			 
            URL url = new URL(stringUrl+sendUrl+param1+param2);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
           
            //POST
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            
            
            /****** Basic 인증 *****/
            String id_pass = "wcadmin:wcadmin";
            String base64Credentials = new String(Base64.getEncoder().encode(id_pass.getBytes()));
            conn.setRequestProperty("Authorization", "Basic " + base64Credentials);
           
            /**********************/
            
            
            //POST 쓰기
            BufferedWriter bw = new BufferedWriter(
            		new OutputStreamWriter(conn.getOutputStream())); 
            bw.write(bw.toString()); 
            bw.flush(); 
            bw.close();
            
            // 리턴된 결과 읽기
            BufferedReader in = new BufferedReader(
            		new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((inputLine = in.readLine()) != null) {
                outResult.append(inputLine+"\n");
            }
            
            conn.disconnect();
            
            System.out.println("outResult.toString() -> "+outResult.toString());
            System.out.println("HTTP API End -----");
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return outResult.toString();
    }
	
}