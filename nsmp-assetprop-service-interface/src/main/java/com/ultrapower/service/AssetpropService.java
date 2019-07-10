package com.ultrapower.service;

import com.ultrapower.pojo.*;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface AssetpropService  {
    /**
     * 显示所有资产
     * @return
     */
    public List<AmAssetQuery> showAllAsset();
    /**
     * 查询所有数据
     * @return
     */
    public List<AmAssetProp> findAllAmAssetProp();

    /**
     * 页面加载所有数据
     * @return
     */
    public Map<String, Object> assetPropPageInit(int pageNum,int pageSize);

    /**
     * 绑定属性显示
     * @param id
     * @return
     */
    public List<AmAssetProp> boundProp(String id);

    /**
     * 添加属性
     */
    public Map<String, Object> saveProp(String ids,java.lang.String pkAssetType);

    /**
     * 解绑属性
     * @param ids
     * @param pkAssetType
     * @return
     */
    public Map<String, Object> deleteProp(String ids,java.lang.String pkAssetType);

    /**
     * 添加属性类
     * @param provVO
     * @param value
     */
    public Map<String,Object> addAmAssetProp(ProvVO provVO, String value);

    /**
     * 页面回显数据
     * @param id
     * @return
     */
    public AmAssetProp showAmAssetProp(String id);

    /**
     * 编辑属性
     * @param amAssetProp
     */
    public Map<String,Object> updateAmAssetProp(AmAssetProp amAssetProp,String value);

    /**
     * 更新属性
     * @param id
     * @return
     */
    public Map<String,Object> assetPropDelete(String id);

    /**
     * 再次查询
     * @return
     */
    public List<AmAssetProp> findAgain(String id);

    /**
     * 模糊查询
     * @param pkAssetType
     * @param propName
     * @return
     */
    public List<AmAssetProp> assetpropController_searchPropByName( String pkAssetType, String propName);

    /**
     * 配置属性页面回显
     * @param pkAssetType
     * @param pkAssetProp
     * @return
     */
    public Map<String,Object> assetPropController_configShow( String pkAssetType, String pkAssetProp);

    /**
     * 配置修改
     * @param amAssetTypeProp
     * @return
     */
    public Map<String,Object> assetpropController_change(AmAssetTypeProp amAssetTypeProp);

    /**
     * 多个条件查询属性
     * @param amAssetProp
     * @return
     */
    public List<AmAssetProp> queryProp(AmAssetProp amAssetProp);
}
