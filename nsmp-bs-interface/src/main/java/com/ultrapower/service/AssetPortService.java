package com.ultrapower.service;

import com.ultrapower.pojo.AdcBmPort;
import com.ultrapower.pojo.AdcBmPortDTO;
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

}
