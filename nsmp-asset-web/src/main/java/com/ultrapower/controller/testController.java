package com.ultrapower.controller;

import com.ultrapower.dao.AmAssetTypeMapper;
import com.ultrapower.pojo.testPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
public class testController {
    @Autowired
    AmAssetTypeMapper amAssetTypeMapper;
    @GetMapping("/test")
    public Map<String,Object> test(){
        Map<String,Object> map =new HashMap<String, Object>();
        //["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        // [5, 20, 36, 10, 10, 20]
        List<String> y = Arrays.asList("5", "20", "36", "10", "10", "20");
        List<String> x = Arrays.asList("衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子");
        map.put("x",x);
        map.put("y",y);
        return map;
    }
    @GetMapping("/test01")
    public Map<String,Object> test01(){
        Map<String,Object> map =new HashMap<String, Object>();
        List<testPojo> testPojos = amAssetTypeMapper.showAsset();
       // ['web应用', '益州','兖州','荆州','幽州']
        List<String> legend = new ArrayList<String>();
        for(testPojo testPojo:testPojos){
            legend.add(testPojo.getTypeName());
        }
        map.put("data1",legend);
      /*  [
        {value:535, name: '荆州'},
        {value:510, name: '兖州'},
        {value:634, name: '益州'},
        {value:735, name: '西凉'}
                            ],*/
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(testPojo testPojo:testPojos) {
            Map<String,Object> map1 =new HashMap<String, Object>();
            map1.put("value", testPojo.getAssetSum());
            map1.put("name", testPojo.getTypeName());
            list.add(map1);
        }
        map.put("data2",list);
        int count=0;
        for(testPojo testPojo:testPojos){
            count +=Integer.valueOf(testPojo.getAssetSum());
        }
        map.put("data3",count);
        return map;
    }

}
