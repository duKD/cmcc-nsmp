package com.ultrapower.controller;

import com.ultrapower.service.AssetPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AssetPortController {
    @Autowired
    AssetPortService assetPortService;

    /**
     * 集团用户页面所有数据加载
     * @return
     */
    @GetMapping("/showAllPageMsg")
    public Map<String ,Object> showAllPageMsg(){
        Map<String, Object> map = assetPortService.showAllPageMsg();
        return map;
    }

    /**
     * 省级用户页面所有数据加载
     * @return
     */
    @GetMapping("/showAllPageMsgProv")
    public Map<String ,Object> showAllPageMsgProv(@CookieValue("token") String value){
        Map<String, Object> map = assetPortService.showAllPageMsgProv(value);
        return map;
    }

}
