package com.ultrapower.controller;

import com.github.pagehelper.PageInfo;
import com.ultrapower.pojo.*;
import com.ultrapower.service.AmBsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class AmBsGroupController {
    @Autowired
    private AmBsGroupService amBsGroupService;
    /**
     * 集团业务树
     * @return
     */
    @GetMapping("sortAllAmBs")
    public List<Nodes> sortAllAmBs(){
        List<Nodes> nodes = amBsGroupService.sortAllAmBs();
        return nodes;
    }
    /**
     * 页面所有数据显示
     * @param
     * @return
     */
    @GetMapping("pageDatashow")
    Map<String,Object> pageDatashow(@RequestParam String name, HttpServletResponse response,
                                    @RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "3")int pageSize){
        Map<String, Object> map= amBsGroupService.pageDatashow(name,response,pageNum,pageSize);
        return map;
    };
    /**
     * 关联省级系统业务
     * @param id
     * @return
     */
    @GetMapping("showConnectProv")
    public List<BsResultDTO> showConnectProv(@RequestParam String id){
        List<BsResultDTO> bsResultDTO = amBsGroupService.showConnectProv(id);
        return bsResultDTO;
    }

    /**
     * 删除集团业务系统映射的省级业务系统
     * @return
     */
    @GetMapping("deleteAmBsGroupProv")
    public Map<String,Object> deleteAmBsGroupProv(@RequestParam String pkBsGroup,@RequestParam String pKBsProv){
        Map<String, Object> map = amBsGroupService.deleteAmBsGroupProv(pkBsGroup, pKBsProv);
        return map;
    }

    /**
     * 添加集团业务系统
     * @param amBsGroup
     * @return
     */
    @PostMapping("addAmBsProv")
    public Map<String,Object> addAmBsGroup(AmBsGroup amBsGroup, @CookieValue("pkBsGroup") String pkBsGroup,@CookieValue("token")String value){
        Map<String, Object> map = amBsGroupService.addAmBsGroup(amBsGroup, pkBsGroup, value);
        return map;
    }

    /**
     * 编辑集团业务系统
     * @return
     */
    @PostMapping("editAMBsGroup")
    public Map<String,Object> editAMBsGroup(AmBsGroup amBsGroup,String pkBsGroup,String value){
        Map<String, Object> map = amBsGroupService.editAMBsGroup(amBsGroup, pkBsGroup, value);
        return map;
    }

    /**
     * 编辑页面回显集团业务系统
     * @return
     */
    @GetMapping("showAmBsGroup")
    public AmBsGroup showAmBsGroup(@RequestParam String pkBsGroup){
        AmBsGroup amBsGroup = amBsGroupService.showAmBsGroup(pkBsGroup);
          return amBsGroup;
    }

    /**
     * 删除集团系统业务
     * @param pkBsGroup
     * @return
     */
    @GetMapping("deleteAmBsGroup")
    public Map<String,Object> deleteAmBsGroup(String pkBsGroup){
       return null;
    }

    /**
     * 手动映射省级业务系统之未映射数据回显
     * @param pkBsGroup
     * @return
     */
    @GetMapping("showUnboundProv")
    public List<AmBsProv> showUnboundProv(@RequestParam String provCode,@RequestParam String pkBsGroup){
        List<AmBsProv> amBsProvs = amBsGroupService.showUnboundProv(provCode,pkBsGroup);
        return amBsProvs;
    }
    /**
     * 手动映射省级业务系统
     * @param pkBsGroup
     * @param pkBsProv
     */
    @GetMapping("boundProv")
    public Map<String ,Object> boundProv(@RequestParam String pkBsGroup,@RequestParam String pkBsProv,@CookieValue("token") String value){
        Map<String, Object> map = amBsGroupService.boundProv(pkBsGroup, pkBsProv, value);
        return map;
    }

    /**
     * 根据省份正则映射省份业务
     * @param provRegex
     * @return
     */
    @GetMapping("bsGroupProvMappingByProvRegex")
    public List<AmBsProv> bsGroupProvMappingByProvRegex(@RequestParam String provRegex ){
        List<AmBsProv> amBsProvs = amBsGroupService.bsGroupProvMappingByProvRegex(provRegex);
        return amBsProvs;
    }

    /**
     * 添加集团业务
     * @param amGroupAddDTO
     * @param pkBsGroup
     * @param value
     * @return
     */
    @PostMapping("bsGroupAdd")
    public Map<String,Object> bsGroupAdd(AmGroupAddDTO amGroupAddDTO, @CookieValue("pkBsGroup") String pkBsGroup,@CookieValue("token")String value){
        Map<String, Object> map = amBsGroupService.bsGroupAdd(amGroupAddDTO, pkBsGroup, value);
        return map;
    }

    /**
     * 重新映射
     * @param amGroupAddDTO
     * @param pkBsGroup
     * @param value
     * @return
     */
    @PostMapping("bsGroupAddAgain")
    public Map<String,Object> bsGroupAddAgain(AmGroupAddDTO amGroupAddDTO, @CookieValue("pkBsGroup") String pkBsGroup,@CookieValue("token")String value){
        Map<String, Object> map = amBsGroupService.bsGroupAddAgain(amGroupAddDTO, pkBsGroup, value);
        return map;
    }
    /**
     * 删除集团业务
     * @param pkBsGroup
     * @return
     */
    @GetMapping("deleteGroup")
    public Map<String,Object> deleteGroup(@CookieValue("pkBsGroup") String pkBsGroup){
        Map<String, Object> map = amBsGroupService.deleteGroup(pkBsGroup);
        return map;
    }
    @PostMapping("showConnectAssetByCondition")
    public PageInfo<BsGroupConnectAsset> showConnectAssetByCondition(AssetQueryVO assetQueryVO,@CookieValue("pkBsGroup") String pkBsGroup ,
                                                          @RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "3")int pageSize){
        assetQueryVO.setPkBsGroup(pkBsGroup);
        PageInfo<BsGroupConnectAsset> pageInfo = amBsGroupService.showConnectAssetByCondition(assetQueryVO, pageNum, pageSize);
        return pageInfo;
    }
}
