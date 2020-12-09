package com.example.apiclient;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @Value("${packetone.template}")
    String packetOneTemplate;

    @PostMapping("/enrollment")
    public String submitEnrollment(@RequestBody String inputJsonStr){
        System.out.println("Printing packetOneTemplate = "+packetOneTemplate);
        try {
            JSONObject inputJsonObj = (JSONObject) JSONValue.parseWithException(inputJsonStr);
            JSONObject pacOneTemplateJsonObj = (JSONObject) JSONValue.parseWithException(packetOneTemplate);
            JSONObject pacOneJsonObj = (JSONObject) pacOneTemplateJsonObj.get(inputJsonObj.get("version"));
            String url = (String) pacOneJsonObj.get("url");
            JSONObject pacOnePayloadJsonObj = (JSONObject) pacOneJsonObj.get("payload");
            System.out.println("Printing pacOnePayloadJsonObj before map = "+pacOnePayloadJsonObj);
            mapValues(pacOnePayloadJsonObj, (JSONObject) inputJsonObj.get("payload"));
            System.out.println("Printing pacOnePayloadJsonObj after map = "+pacOnePayloadJsonObj);
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<JSONObject> entity = new HttpEntity<>(pacOnePayloadJsonObj);
            String resp = restTemplate.postForObject(url,entity,String.class);
            System.out.println("printing resp from packet creation = "+resp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    private void mapValues(JSONObject pacOneJsonObj, JSONObject enrJsonObj) {
        pacOneJsonObj.forEach((k,v) -> {
            if(v.toString().contains("{")){
                mapValues((JSONObject) v, enrJsonObj);
            }else{
                System.out.println("k = "+k+", v = "+v);
                pacOneJsonObj.replace(k,getValueFromPath(v,enrJsonObj));
            }
        });
    }

    private Object getValueFromPath(Object v, JSONObject enrJsonObj) {
        if(v.toString().contains(".")){
            String[] paths = v.toString().split("\\.",2);
            return getValueFromPath(paths[1], (JSONObject) enrJsonObj.get(paths[0]));
        }else {
            System.out.println("v = "+v+", enrJsonObj = "+enrJsonObj);
            System.out.println("return value = "+enrJsonObj.get(v));
            return enrJsonObj.get(v);
        }
    }
}
