package com.ultrapower.service;

import com.ultrapower.pojo.*;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface AmAssetTypeService {
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
