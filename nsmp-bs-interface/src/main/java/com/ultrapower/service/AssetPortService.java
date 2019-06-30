package com.ultrapower.service;

import com.github.pagehelper.PageInfo;
import com.ultrapower.pojo.AdcBmPort;
import com.ultrapower.pojo.AdcBmPortDTO;
import com.ultrapower.pojo.AmAssetQuery;
import com.ultrapower.pojo.BdmProv;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

public interface AssetPortService {
    /**
     * 显示页面所有数据
     * @return
     */
    public Map<String ,Object> showAllPageMsg( String value);
    /**
     * 省级用户页面所有数据加载
     * @return
     */
    public Map<String ,Object> showAllPageMsgProv(String value);
    /**
     * 全部省份下的最新资产端口基准列表
     * @return
     */
    public List<AdcBmPortDTO> showAllPort(String value);
    /**
     * 单个省份下的最新资产端口基准列表
     * @return
     */
    public List<AdcBmPortDTO> showAllPortProv(String id);

    /**
     * 根据条件查询端口基准
     * @param adcBmPort
     * @return
     */
    public List<AdcBmPortDTO> searchBmPortBycondition(AdcBmPort adcBmPort);

    /**
     * 显示省份下拉框，
     * @return
     */
    public List<BdmProv> showProvList();

    /**
     * 显示添加端口页面所有数据
     * @return
     */
    public Map<String ,Object> showAllAddPage(int pageNum,int pageSize);
    /**
     * 显示未选择的资产
     */
    public PageInfo<AmAssetQuery> showUnboundAsset(int pageNum, int pageSize);
}
