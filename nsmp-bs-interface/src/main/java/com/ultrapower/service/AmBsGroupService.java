package com.ultrapower.service;

import com.github.pagehelper.PageInfo;
import com.ultrapower.pojo.*;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AmBsGroupService {
    /**
     * 集团业务树
     * @return
     */
    List<Nodes> sortAllAmBs();

    /**
     * 页面所有数据显示
     * @param
     * @return
     */
    Map<String,Object> pageDatashow(String name, HttpServletResponse response,int pageNum,int pageSize);

    /**
     * 根据集团系统业务查询数据
     * @param name
     * @return
     */
    AmBsGroup findAmBsGroupByName(String name, HttpServletResponse response);

    /**
     * 关联省级系统业务
     * @param id
     * @return
     */
    List<BsResultDTO> showConnectProv(String id);
    /**
     * 删除集团业务系统映射的省级业务系统
     * @return
     */
    public Map<String,Object> deleteAmBsGroupProv(String pkBsGroup,String pkBsProv);
    /**
     * 添加集团业务系统
     * @param amBsGroup
     * @return
     */
    public Map<String,Object> addAmBsGroup(AmBsGroup amBsGroup,String pkBsGroup,String value);

    /**
     * 编辑集团业务系统
     * @return
     */
    public Map<String,Object> editAMBsGroup(AmBsGroup amBsGroup,String pkBsGroup,String value);

    /**
     * 编辑页面回显集团业务系统
     * @return
     */
    public AmBsGroup showAmBsGroup(String id);
    /**
     * 删除集团系统业务
     * @param pkBsGroup
     * @return
     */
    public Map<String,Object> deleteAmBsGroup(String pkBsGroup);
    /**
     * 手动映射省级业务系统之未映射数据回显
     * @param provCode,pkBsGroup
     * @return
     */
    public List<AmBsProv> showUnboundProv(String provCode,String pkBsGroup);

    /**
     * 手动映射省级业务系统
     * @param pkBsGroup
     * @param pkBsProv
     * @return
     */
    public Map<String ,Object>  boundProv(String pkBsGroup, String pkBsProv,String value);

    /**
     * 根据省份正则映射省份业务
     * @param provRegex
     * @return
     */
    public List<AmBsProv> bsGroupProvMappingByProvRegex(@RequestParam String provRegex );
    /**
     * 添加集团业务
     * @param amGroupAddDTO
     * @param pkBsGroup
     * @param value
     * @return
     */
    public Map<String,Object> bsGroupAdd(AmGroupAddDTO amGroupAddDTO, @CookieValue("pkBsGroup") String pkBsGroup, @CookieValue("token")String value);

    /**
     * 删除集团业务
     * @param pkBsGroup
     * @return
     */
    public Map<String,Object> deleteGroup(@CookieValue("pkBsGroup") String pkBsGroup);

    /**
     * 省份下拉框
     * @return
     */
    public List<BdmProv>  showBdmProv();

    /**
     * 重新映射
     * @param amGroupAddDTO
     * @param pkBsGroup
     * @param value
     * @return
     */
    public Map<String,Object> bsGroupAddAgain(AmGroupAddDTO amGroupAddDTO, @CookieValue("pkBsGroup") String pkBsGroup,@CookieValue("token")String value);

    /**
     * 条件查询 ，资产
     * @param assetQueryVO
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<BsGroupConnectAsset> showConnectAssetByCondition(AssetQueryVO assetQueryVO, int pageNum, int pageSize);

}
