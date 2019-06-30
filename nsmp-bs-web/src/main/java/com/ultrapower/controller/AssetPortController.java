package com.ultrapower.controller;

import com.github.pagehelper.PageInfo;
import com.ultrapower.pojo.AdcBmPort;
import com.ultrapower.pojo.AdcBmPortDTO;
import com.ultrapower.pojo.AmAssetQuery;
import com.ultrapower.service.AssetPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public Map<String ,Object> showAllPageMsg(@CookieValue("token") String value){
        Map<String, Object> map = assetPortService.showAllPageMsg(value);
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

    /**
     * 根据条件查询端口基准
     * @param adcBmPort
     * @return
     */
    @PostMapping("searchBmPortBycondition")
    public List<AdcBmPortDTO> searchBmPortBycondition(AdcBmPort adcBmPort){
        List<AdcBmPortDTO> adcBmPortDTOS = assetPortService.searchBmPortBycondition(adcBmPort);
        return adcBmPortDTOS;
    }
    /**
     * 显示添加端口页面所有数据
     * @return
     */
    @GetMapping("/showAllAddPage")
    public Map<String, Object> showAllAddPage(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "4") int pageSize){
        Map<String, Object> map = assetPortService.showAllAddPage(pageNum,pageSize);
        return map;
    }

    /**
     *  根据条件查询未选资产
     * @param amAssetQuery
     * @return
     */
    @PostMapping("/searchAmAssetBycondition")
    public PageInfo<AmAssetQuery> searchAmAssetBycondition(AmAssetQuery amAssetQuery){
        PageInfo<AmAssetQuery> pageInfo = assetPortService.searchAmAssetBycondition(amAssetQuery);
        return pageInfo;
    }
}
