package com.ultrapower.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dao.*;
import com.ultrapower.pojo.*;
import com.ultrapower.util.PkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    AmBsProvMapper amBsProvMapper;
    @Autowired
    AmAssetTypeMapper amAssetTypeMapper;
    @Autowired
    AdcBmPortAssetMapper adcBmPortAssetMapper;

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
        AmUser amUser = getAmUser(value);
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
     * @param adcBmPort1
     * @return
     */
    public List<AdcBmPortDTO> searchBmPortBycondition(AdcBmPort1 adcBmPort1) {
        List<AdcBmPortDTO> adcBmPortDTOS = adcBmPortMapper.searchBmPortBycondition(adcBmPort1);
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
        //2.省份下拉框
        List<BdmProv> bdmProvs = showProvList();
        map.put("bdmProvs",bdmProvs);
        //3.业务系统下拉框
        List<AmBsProv> amBsProvs = showBsNameList();
        map.put("amBsProvs",amBsProvs);
        //4.资产类型下拉框
        List<AmAssetType> amAssetTypes = showAssetType();
        map.put("amAssetTypes",amAssetTypes);
        return map;
    }

    /**
     * 显示未选择的资产
     * @return
     */
    public PageInfo<AmAssetQuery> showUnboundAsset(int pageNum,int pageSize) {
        AmAssetQuery amAssetQuery=new AmAssetQuery();
        PageHelper.startPage(pageNum,pageSize);
        List<AmAssetQuery> amAssetQueries = amAssetMapper.showUnboundAsset(amAssetQuery);
        PageInfo<AmAssetQuery> pageInfo = new PageInfo<AmAssetQuery>(amAssetQueries);
        return pageInfo;
    }

    /**
     * 显示业务系统下拉框
     * @return
     */
    public List<AmBsProv> showBsNameList() {
        List<AmBsProv> amBsProvs = amBsProvMapper.showBsNameList();
        return amBsProvs;
    }

    /**
     * 显示资产类型下拉框
     * @return
     */
    public List<AmAssetType> showAssetType() {
        List<AmAssetType> amAssetTypes = amAssetTypeMapper.showAssetType();
        return amAssetTypes;
    }

    /**
     * 根据条件查询未选资产
     * @param amAssetQuery
     * @return
     */
    public PageInfo<AmAssetQuery> searchAmAssetBycondition(AmAssetQuery amAssetQuery) {
        int pageNum=Integer.valueOf(amAssetQuery.getPageNum());
        int pageSize=Integer.valueOf(amAssetQuery.getPageSize());
        amAssetQuery.setAssetIp("%"+amAssetQuery.getAssetIp()+"%");
        amAssetQuery.setAssetName("%"+amAssetQuery.getAssetName()+"%");
        PageHelper.startPage(pageNum, pageSize);
        List<AmAssetQuery> amAssetQueries = amAssetMapper.showUnboundAsset(amAssetQuery);
        PageInfo<AmAssetQuery> pageInfo = new PageInfo<AmAssetQuery>(amAssetQueries);
        return pageInfo;
    }

    /**
     * 添加端口基准信息
     * @param adcBmPorts
     * @param ids
     * @param value
     * @return
     */
    public Map<String, Object> saveBmPort(List<AdcBmPort> adcBmPorts, String ids, String value) {
        Map<String, Object> map=new HashMap();
        try {
            String[] split = ids.split(",");
            AmUser amUser = getAmUser(value);
            String provCode=amUser.getProvCode();
            String pkNsmpUser = amUser.getPkNsmpUser();
            Date date = new Date();
            for(AdcBmPort adcBmPort :adcBmPorts){
                //1.先向端口表加入数据
                adcBmPort.setProvCode(provCode);
                String pkBmPort=PkUtils.getUUID();
                adcBmPort.setPkBmPort(pkBmPort);
                adcBmPort.setIsDeleted(0);
                adcBmPort.setPkCreator(pkNsmpUser);
                adcBmPort.setCreateTime(date);
                adcBmPort.setPkMender(pkNsmpUser);
                adcBmPort.setMendTimeLast(date);
                adcBmPortMapper.insert(adcBmPort);
                //2.再向关联表加入数据
                for(String pKAsset:split){
                    AdcBmPortAsset adcBmPortAsset = new AdcBmPortAsset();
                    adcBmPortAsset.setPkBmPortAsset(PkUtils.getUUID());
                    adcBmPortAsset.setPkBmPort(pkBmPort);
                    adcBmPortAsset.setPkAsset(pKAsset);
                    adcBmPortAsset.setProvCode(provCode);
                    adcBmPortAssetMapper.insert(adcBmPortAsset);
                }
            }
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    public AmUser getAmUser(String value){
        String pkUser = redisTemplate.boundHashOps("session").get("token_" + value) + "";
        AmUser amUser = amUserMapper.selectByPrimaryKey(pkUser);
        return amUser;
    }

}
