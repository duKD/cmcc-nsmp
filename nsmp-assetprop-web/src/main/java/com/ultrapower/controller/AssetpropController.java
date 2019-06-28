package com.ultrapower.controller;

import com.ultrapower.pojo.AmAssetProp;
import com.ultrapower.pojo.AmAssetTypeProp;
import com.ultrapower.service.AssetpropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AssetpropController {
    @Autowired
    AssetpropService assetpropService;
    @Autowired
    RedisTemplate redisTemplate;
    /**
     * 页面加载所有数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("assetPropPageInit")
    public Map<String, Object> assetPropPageInit(@RequestParam(defaultValue = "1") int pageNum,
                                                 @RequestParam(defaultValue = "3") int pageSize){
        //  proplist(hash的名字)  proplist_1_3  map
        String key = "proplist_"+pageNum+"_"+pageSize;
        Boolean b = redisTemplate.boundHashOps("proplist").hasKey(key);
        if(b){
            //从Redis中拿数据
            Map<String, Object> map = (Map<String, Object>)redisTemplate.boundHashOps("proplist").get(key);
            System.out.println("proplist   ----  redis");
            return map;
        }
        Map<String, Object> map = assetpropService.assetPropPageInit(pageNum,pageSize);
        System.out.println("proplist   ----  mysql");
        //向redis中存数据
        redisTemplate.boundHashOps("proplist").put(key,map);
        return map;
    }
    /**
     * 绑定属性
     * @param id
     * @return
     */
    @GetMapping("boundProp")
    public List<AmAssetProp> boundProp(@RequestParam String id){
        List<AmAssetProp> amAssetProps = assetpropService.boundProp(id);
        return amAssetProps;
    }
    @GetMapping("saveProp")
    public Map<String, Object> saveProp(@RequestParam String ids,@CookieValue("pkAssetType") String pkAssetType){
        Map<String, Object> map = assetpropService.saveProp(ids, pkAssetType);
        //父页面再次显示
        List<AmAssetProp> amAssetProps = assetpropService.findAgain(pkAssetType);
        map.put("amAssetProps",amAssetProps);
        return map;
    }
    /**
     * 解绑属性
     * @param ids
     * @param pkAssetType
     * @return
     */
    @GetMapping("deleteProp")
    public Map<String, Object> deleteProp(@RequestParam String ids, @RequestParam String pkAssetType){
        Map<String, Object> map = assetpropService.deleteProp(ids, pkAssetType);
        //再次更新数据
        List<AmAssetProp> amAssetProps = assetpropService.findAgain(pkAssetType);
        map.put("amAssetProps",amAssetProps);
        return map;
    }

    /**
     * 添加属性
     */
    @PostMapping("addAmAssetProp")
    public void addAmAssetProp(AmAssetProp amAssetProp,@CookieValue("token") String value){
       assetpropService.addAmAssetProp(amAssetProp,value);
    }

    /**
     * 页面数据回显
     * @param id
     * @return
     */
    @GetMapping("showAssetProp")
    public AmAssetProp showAssetProp(@RequestParam String id){
        AmAssetProp amAssetProp = assetpropService.showAmAssetProp(id);
        return amAssetProp;
    }

    /**
     * 更新属性
     * @param amAssetProp
     */
    @PostMapping("updateAmAssetProp")
    public Map<String,Object> updateAmAssetProp(AmAssetProp amAssetProp,@CookieValue("token") String value){
        Map<String, Object> map = assetpropService.updateAmAssetProp(amAssetProp, value);
        return map;
    }

    /**
     * 删除属性
     * @param id
     * @return
     */
    @PostMapping("assetPropDelete")
    public Map<String,Object> assetPropDelete(@RequestParam String id){
        Map<String, Object> map = assetpropService.assetPropDelete(id);
        return map;
    }

    /**
     * 根据名字查询属性
     * @param pkAssetType
     * @param propName
     * @return
     */
    @GetMapping("AssetpropController_searchPropByName")
    public List<AmAssetProp> assetpropController_searchPropByName(@RequestParam String pkAssetType,@RequestParam String propName){
        List<AmAssetProp> amAssetProps = assetpropService.assetpropController_searchPropByName(pkAssetType, propName);
        return amAssetProps;
    }

    /**
     * 配置属性页面回显
     * @param pkAssetType
     * @param pkAssetProp
     * @return
     */
    @GetMapping("AssetPropController_configShow")
    public Map<String,Object> assetPropController_configShow(@RequestParam String pkAssetType,@RequestParam String pkAssetProp){
        Map<String, Object> map = assetpropService.assetPropController_configShow(pkAssetType, pkAssetProp);
        return map;
    }
    @PostMapping("assetpropController_change")
    public Map<String,Object> assetpropController_change(AmAssetTypeProp amAssetTypeProp){
        Map<String, Object> map = assetpropService.assetpropController_change(amAssetTypeProp);
        List<AmAssetProp> amAssetProps = assetpropService.findAgain(amAssetTypeProp.getPkAssetType());
        map.put("amAssetProps",amAssetProps);
        return map;
    }

    /**
     * 多个条件查询
     * @param amAssetProp
     * @return
     */
    @PostMapping("queryProp")
    public List<AmAssetProp> queryProp(AmAssetProp amAssetProp){
        List<AmAssetProp> amAssetProps = assetpropService.queryProp(amAssetProp);
        return amAssetProps;
    }
}
