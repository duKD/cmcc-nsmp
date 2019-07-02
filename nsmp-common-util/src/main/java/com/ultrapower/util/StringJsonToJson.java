package com.ultrapower.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ultrapower.pojo.AdcBmPort;

import java.util.*;

public class StringJsonToJson {

    public static List<AdcBmPort> jsonStringToList(String rsContent) throws Exception
    {
        JSONArray arry = JSONArray.parseArray(rsContent);
        //System.out.println("json字符串内容如下");
        //System.out.println(arry);
        List<AdcBmPort> rsList = new ArrayList();
        for (int i = 0; i < arry.size(); i++)
        {
            JSONObject jsonObject = arry.getJSONObject(i);
            Map<String, String> map = new HashMap<String, String>(); //new Port
            AdcBmPort adcBmPort = new AdcBmPort();
            for (Iterator<?> iter = jsonObject.keySet().iterator(); iter.hasNext();)
            {
                String key = (String) iter.next();
                String value = jsonObject.get(key).toString();
                map.put(key, value);
            }
            adcBmPort.setPortType(Integer.valueOf(map.get("portType")));
            adcBmPort.setProtocol(map.get("protocol"));
            adcBmPort.setPort(map.get("port"));
            adcBmPort.setSeverityLevel(Integer.valueOf(map.get("severityLevel")));
            rsList.add(adcBmPort);
        }
        return rsList;
    }

}
