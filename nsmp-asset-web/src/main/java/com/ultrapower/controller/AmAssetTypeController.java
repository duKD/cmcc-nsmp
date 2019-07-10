package com.ultrapower.controller;

import com.ultrapower.pojo.*;
import com.ultrapower.service.AmAssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AmAssetTypeController {
    @Autowired
    AmAssetTypeService amAssetTypeService;

    /**
     * es高级搜索
     * @param id
     * @return
     */
    @GetMapping("/queryAllAssetByAssetPk")
    public Map<String,Object> queryAllAssetByAssetPk(@RequestParam String id){
        Map<String, Object> map = amAssetTypeService.queryAllAssetByAssetPk(id);
        return map;
    }
    /**
     * 资产下线
     * @param id
     * @return
     */
    @PostMapping("/changeAssetStateOff")
    public Map<String,Object> changeAssetStateOff(@RequestParam String id){
        Map<String, Object> map = amAssetTypeService.changeAssetStateOff(id);
        return map;
    }
    /**
     * 资产上线
     * @param id
     * @return
     */
    @PostMapping("/changeAssetStateOn")
    public Map<String,Object> changeAssetStateOn(@RequestParam String id){
        Map<String, Object> map = amAssetTypeService.changeAssetStateOn(id);
        return map;
    }
    /**
     * 编辑资产
     * @param addAssetVO
     * @return
     */
    @PostMapping("/editAsset")
    public Map<String,Object> editAsset(@RequestBody AddAssetVO addAssetVO){
        Map<String, Object> map = amAssetTypeService.editAsset(addAssetVO);
        return map;
    }
    /**
     * 编辑资产页面数据回显
     * @param id
     * @return
     */
    @GetMapping("/showAssetAagin")
    public Map<String,Object> showAssetAagin(@RequestParam String id){
        Map<String, Object> map = amAssetTypeService.showAssetAagin(id);
        return map;
    }
    /**
     * 显示绑定属性名称
     * @param pkAssetType
     */
    @GetMapping("/showAllBoundprop")
    public List<VueVO> showAllBoundprop(@RequestParam String pkAssetType){
        List<VueVO> amAssetProps = amAssetTypeService.showAllBoundprop(pkAssetType);
        return amAssetProps;
    }
    /**
     * 添加资产页面数据显示
     * @return
     */
    @GetMapping("/showAssetMsg")
    public Map<String, Object> showAssetMsg(){
        Map<String, Object> map = amAssetTypeService.showAssetMsg();
        return map;
    }
    /**
     * 添加资产
     * @return
     */
    @PostMapping("/addAsset")
    public Map<String,Object> addAsset(@RequestBody AddAssetVO addAssetVO){
        Map<String, Object> map = amAssetTypeService.addAsset(addAssetVO);
        return map;
    }
    /**
     * 资产查询列表
     */
    @GetMapping("findAllAmAssetType")
    public List<AmAssetType> findAllAmAssetType(){
        List<AmAssetType> allAmAssetType = amAssetTypeService.findAllAmAssetType();
        return allAmAssetType;
    }

    /**
     * 资产类型树
     * @return
     */
    @GetMapping("sortAllAmAsset")
    public List<Nodes> sortAllAmAsset() {
        List<Nodes> nodesList = amAssetTypeService.sortAllAmAsset();
        return nodesList;
    }

    @GetMapping("findAllAmAssetTypeByName")
    public AmAssetType findAllAmAssetTypeByName(@RequestParam String name) {
        List<AmAssetType> amAssetType = amAssetTypeService.findAllAmAssetTypeByName(name);
        return amAssetType.get(0);
    }

    @PostMapping("findAllAmAssetTypeByCondition")
    public List<AmAssetType> findAllAmAssetTypeByCondition(QueryVO queryVO) {
        List<AmAssetType> amAssetTypes = amAssetTypeService.findAllAmAssetTypeByCondition(queryVO);
        return amAssetTypes;
    }

    @PostMapping("findAllFirstType")
    public List<AmAssetType> findAllFirstType() {
        List<AmAssetType> amAssetTypes = amAssetTypeService.findAllFirstType();
        return  amAssetTypes;
    }
    @PostMapping("addAmAssetType")
    public int addAmAssetType(AmAssetType amAssetType, @CookieValue("pkNsmpUser") String cookie){
        int i = amAssetTypeService.addAmAssetType(amAssetType, cookie);
        return i;
    }

    /**
     * 根据ID查询资产
     * @param id
     * @return
     */
    @RequestMapping("findAmAssetTypeById")
    Map<String ,Object> findAmAssetTypeById(@RequestParam String id){
        AmAssetType amAssetType = amAssetTypeService.findAmAssetTypeById(id);
        Map<String ,Object> map = new HashMap ();
        map.put("pkAssetType",amAssetType.getPkAssetType());
        map.put("typeName",amAssetType.getTypeName());
        map.put("typeCode",amAssetType.getTypeCode());
        map.put("typeDesc",amAssetType.getTypeDesc());
        map.put("pkTypeParent",amAssetType.getPkTypeParent());
        return map;
    }

    /**
     * 页面编辑显示
     * @param id
     * @return
     */
    @RequestMapping("findAssetTypeDataInitEditPage")
     List<Object> findAssetTypeDataInitEditPage(@RequestParam String id){
        //页面回显数据
        AmAssetType amAssetType = amAssetTypeService.findAmAssetTypeById(id);
        Map<String ,Object> map = new HashMap();
        map.put("pkAssetType",amAssetType.getPkAssetType());
        map.put("typeName",amAssetType.getTypeName());
        map.put("typeCode",amAssetType.getTypeCode());
        map.put("typeDesc",amAssetType.getTypeDesc());
        map.put("pkTypeParent",amAssetType.getPkTypeParent()==null?"root":amAssetType.getPkTypeParent());
        //所有一级资产
        List<AmAssetType> amAssetTypes = amAssetTypeService.findAllFirstType();
        ArrayList<Object> list = new ArrayList();
        list.add(amAssetTypes);
        list.add(map);
        return list;
    }
    @PostMapping("updateAssetType")
    public void updateAssetType( AmAssetType amAssetType,@CookieValue("token") String value){
       amAssetTypeService.updateAssetType(amAssetType,value);
    }
    @PostMapping("deleteAssetType")
    public Map<String,Object> deleteAssetType(@RequestParam String id){
        Map<String,Object>  map = new HashMap();
        int i = amAssetTypeService.deleteAssetType(id);
        if(i>0){
            map.put("code",1);
            map.put("msg","删除成功");
        }else{
        map.put("code",0);
        map.put("msg","删除失败");
        }
        return map;
    }
    @PostMapping("deleteAssetTypeByIds")
    public Map<String,Object> deleteAssetTypeByIds(String ids){
        Map<String, Object> map = amAssetTypeService.deleteAssetTypeByIds(ids);
        return map;
    }
    @GetMapping("findAmAssetTypeAndPropListByName")
    public Map<String, Object> findAmAssetTypeAndPropListByName(@RequestParam String name, HttpServletResponse response){
        Map<String, Object> map = amAssetTypeService.findAmAssetTypeAndPropListByName(name,response);
        return map;
    }

}
