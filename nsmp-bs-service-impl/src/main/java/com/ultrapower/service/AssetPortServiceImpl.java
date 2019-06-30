package com.ultrapower.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dao.AdcBmPortMapper;
import com.ultrapower.dao.AmAssetMapper;
import com.ultrapower.dao.AmUserMapper;
import com.ultrapower.dao.BdmProvMapper;
import com.ultrapower.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AssetPortServiceImpl implements AssetPortService {
    @Autowired
    AdcBmPortMapper adcBmPortMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    AmUserMapper amUserMapper;
    @Autowired
    BdmProvMapper bdmProvMapper;
    @Autowired
    AmAssetMapper amAssetMapper;

    /**
     * 集团用户页面所有数据显示
     * @return
     */
    public Map<String, Object> showAllPageMsg(String value) {
        Map<String, Object> map=new HashMap<String, Object>();
        //1.端口基准列表
        List<AdcBmPortDTO> adcBmPorts = showAllPort(value);
        map.put("adcBmPorts",adcBmPorts);
        //2.省份下拉框
        List<BdmProv> bdmProvs = showProvList();
        map.put("bdmProvs",bdmProvs);
        return map;
    }

    /**
     * 省级用户页面所有数据显示
     * @return
     */
    public Map<String, Object> showAllPageMsgProv(String value) {
        Map<String, Object> map=new HashMap<String, Object>();
        //1.端口基准列表
        List<AdcBmPortDTO> adcBmPorts = showAllPortProv(value);
        map.put("adcBmPorts",adcBmPorts);
        return map;
    }

    /**
     * 全部省份下的最新资产端口基准列表
     * @return
     */
    public List<AdcBmPortDTO> showAllPort( String value) {
        String pkUser = redisTemplate.boundHashOps("session").get("token_" + value) + "";
        AmUser amUser = amUserMapper.selectByPrimaryKey(pkUser);
        List<AdcBmPortDTO> adcBmPorts = adcBmPortMapper.showAllPortProv(amUser);
        return adcBmPorts;
    }
    /**
     * 当个省份下的最新资产端口基准列表
     * @return
     */
    public List<AdcBmPortDTO> showAllPortProv(String value) {
        //从redis中取出用户id
        String pkUser = redisTemplate.boundHashOps("session").get("token_" + value) + "";
        AmUser amUser = amUserMapper.selectByPrimaryKey(pkUser);
        List<AdcBmPortDTO> adcBmPorts = adcBmPortMapper.showAllPortProv(amUser);
        return adcBmPorts;
    }
    /**
     * 根据条件查询端口基准
     * @param adcBmPort
     * @return
     */
    public List<AdcBmPortDTO> searchBmPortBycondition(AdcBmPort adcBmPort) {
        List<AdcBmPortDTO> adcBmPortDTOS = adcBmPortMapper.searchBmPortBycondition(adcBmPort);
        return adcBmPortDTOS;
    }

    /**
     * 显示省份下拉框
     * @return
     */
    public List<BdmProv> showProvList() {
        List<BdmProv> bdmProvs = bdmProvMapper.selectByExample(null);
        return bdmProvs;
    }
    /**
     * 显示添加端口页面所有数据
     * @return
     */
    public Map<String, Object> showAllAddPage(int pageNum,int pageSize) {
        Map<String, Object> map= new HashMap();
        //1.未选资产
        PageInfo<AmAssetQuery> pageInfo = showUnboundAsset(pageNum, pageSize);
        map.put("pageInfo",pageInfo);
        return map;
    }

    /**
     * 显示未选择的资产
     * @return
     */
    public PageInfo<AmAssetQuery> showUnboundAsset(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AmAssetQuery> amAssetQueries = amAssetMapper.showUnboundAsset();
        PageInfo<AmAssetQuery> pageInfo = new PageInfo<AmAssetQuery>(amAssetQueries);
        return pageInfo;
    }

}
