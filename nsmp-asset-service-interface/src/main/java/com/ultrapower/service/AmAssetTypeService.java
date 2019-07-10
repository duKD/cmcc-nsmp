package com.ultrapower.service;

import com.ultrapower.pojo.*;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface AmAssetTypeService {
    /**
     * es高级搜索
     * @param id
     * @return
     */
    public Map<String,Object> queryAllAssetByAssetPk(String id);
    /**
     * 资产下线
     * @param id
     * @return
     */
    public Map<String,Object> changeAssetStateOff(String id);
    /**
     * 资产上线
     * @param id
     * @return
     */
    public Map<String,Object> changeAssetStateOn(String id);
    /**
     * 编辑资产
     * @param addAssetVO
     * @return
     */
    public Map<String,Object> editAsset( AddAssetVO addAssetVO);
    /**
     * 编辑资产页面数据回显
     * @param id
     * @return
     */
    public Map<String,Object> showAssetAagin(String id);

    /**
     * 显示属性名称
     * @param pkAssetType
     * @return
     */
    public List<VueVO> showAllBoundprop(String pkAssetType);
    /**
     * 添加资产
     * @param addAssetVO
     * @return
     */
    public Map<String,Object> addAsset( AddAssetVO addAssetVO);
    /**
     *添加资产页面数据显示
     * @return
     */
    public Map<String,Object> showAssetMsg();
    /**
     * 查询所有
     * @return
     */
    public List<AmAssetType> findAllAmAssetType();

    /**
     * 分级显示
     * @return
     */
    public List<Nodes>  sortAllAmAsset();

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    public List<AmAssetType> findAllAmAssetTypeByName(String name);

    /**
     * 分类查询列表
     * @param queryVO
     * @return
     */
    public List<AmAssetType> findAllAmAssetTypeByCondition(QueryVO queryVO);

    /**
     * 查询所有一级别的资产
     * @return
     */
    public List<AmAssetType> findAllFirstType();

    /**
     * 新增资产
     * @param amAssetType
     * @param cookie
     * @return
     */
    public int addAmAssetType(AmAssetType amAssetType,String cookie);

    /**
     * 根据ID查询资产
     * @param id
     * @return
     */
    AmAssetType findAmAssetTypeById(String id);

    /**
     * 编辑修改资产类型
     * @param amAssetType
     * @param value
     */
    public void updateAssetType(AmAssetType amAssetType,String value);

    /**
     * 隐藏数据
     * @param id
     * @return
     */
    public int deleteAssetType(String id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Map<String,Object> deleteAssetTypeByIds(String ids);

    /**
     * 资产类型列表页面详情
     * @param name
     * @return
     */
    public Map<String, Object> findAmAssetTypeAndPropListByName(String name, HttpServletResponse response);

}
