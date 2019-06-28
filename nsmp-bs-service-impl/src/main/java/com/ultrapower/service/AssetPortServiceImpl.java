package com.ultrapower.service;

import com.ultrapower.dao.AdcBmPortMapper;
import com.ultrapower.dao.AmUserMapper;
import com.ultrapower.pojo.AdcBmPort;
import com.ultrapower.pojo.AdcBmPortExample;
import com.ultrapower.pojo.AmUser;
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
    /**
     * 集团用户页面所有数据显示
     * @return
     */
    public Map<String, Object> showAllPageMsg() {
        Map<String, Object> map=new HashMap<String, Object>();
        //1.端口基准列表
        List<AdcBmPort> adcBmPorts = showAllPort();
        map.put("adcBmPorts",adcBmPorts);
        return map;
    }

    /**
     * 省级用户页面所有数据显示
     * @return
     */
    public Map<String, Object> showAllPageMsgProv(String value) {
        Map<String, Object> map=new HashMap<String, Object>();
        //1.端口基准列表
        List<AdcBmPort> adcBmPorts = showAllPortProv(value);
        map.put("adcBmPorts",adcBmPorts);
        return map;
    }

    /**
     * 全部省份下的最新资产端口基准列表
     * @return
     */
    public List<AdcBmPort> showAllPort() {
        AdcBmPortExample adcBmPortExample = new AdcBmPortExample();
        AdcBmPortExample.Criteria criteria = adcBmPortExample.createCriteria();
        criteria.andIsDeletedEqualTo(0);
        List<AdcBmPort> adcBmPorts = adcBmPortMapper.selectByExample(adcBmPortExample);
        return adcBmPorts;
    }

    /**
     * 当个省份下的最新资产端口基准列表
     * @return
     */
    public List<AdcBmPort> showAllPortProv(String value) {
        //从redis中取出用户id
        String pkUser = redisTemplate.boundHashOps("session").get("token_" + value) + "";
        AmUser amUser = amUserMapper.selectByPrimaryKey(pkUser);
        List<AdcBmPort> adcBmPorts = adcBmPortMapper.showAllPortProv(amUser.getProvCode());
        return adcBmPorts;
    }
}
