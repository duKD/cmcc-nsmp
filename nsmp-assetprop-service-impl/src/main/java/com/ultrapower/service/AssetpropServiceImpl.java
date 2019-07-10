package com.ultrapower.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.dao.*;
import com.ultrapower.pojo.*;
import com.ultrapower.util.PkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AssetpropServiceImpl implements AssetpropService {
    @Autowired
    AmAssetPropMapper amAssetPropMapper;
    @Autowired
    AmPropClassMapper amPropClassMapper;
    @Autowired
    AmAssetTypePropMapper amAssetTypePropMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    AmAssetPropValueMapper amAssetPropValueMapper;
    @Autowired
    AmAssetMapper amAssetMapper;



    /**
     * 查询所有资产
     * @return
     */
    public List<AmAssetQuery> showAllAsset() {
        List<AmAssetQuery> amAssetQueries = amAssetMapper.showAllAsset();
        return amAssetQueries;
    }

    /**
     * 查询所有数据
     * @return
     */
    public List<AmAssetProp> findAllAmAssetProp() {
        AmAssetPropExample amAssetPropExample = new AmAssetPropExample();
        AmAssetPropExample.Criteria criteria = amAssetPropExample.createCriteria();
        Short IS_VIEW = 1 ;
        Short IS_DELETED = 0 ;
        criteria.andIsDeletedEqualTo(IS_DELETED);
        criteria.andIsViewEqualTo(IS_VIEW);
        List<AmAssetProp> amAssetProps = amAssetPropMapper.selectByExample(amAssetPropExample);
        PageInfo<AmAssetProp> pageInfo = new PageInfo<AmAssetProp>(amAssetProps);
        return amAssetProps;
    }
    /**
     * 页面加载所有数据
     * @return
     */
    public Map<String, Object> assetPropPageInit(int pageNum,int pageSize) {
        Map<String,Object> result = new HashMap();
        //1.表格中的属性数据
        //（1）设置分页
        //PageHelper.startPage(pageNum,pageSize);
        PageHelper.startPage(pageNum,pageSize);
        // （2）  1.表格中的属性数据（查数据库）
        List<AmAssetProp> allAmAssetProp = amAssetPropMapper.findAllProp();
        //（3）创建PageInfo
        PageInfo<AmAssetProp> pageInfo = new PageInfo<AmAssetProp>(allAmAssetProp);
        //2.属性分类
        List<AmPropClass> amPropClasses = amPropClassMapper.selectByExample(null);
        //3、业务分类       1=通用属性、2=硬件属性、3=软件属性、4=登录属性、5=自定义属性
        Map<String, String> type1 = new HashMap<String,String>();
        type1.put("bsTypeId","1");
        type1.put("bsTypeName","通用属性");

        Map<String, String> type2 = new HashMap<String,String>();
        type2.put("bsTypeId","2");
        type2.put("bsTypeName","硬件属性");

        Map<String, String> type3 = new HashMap<String,String>();
        type3.put("bsTypeId","3");
        type3.put("bsTypeName","软件属性");

        Map<String, String> type4 = new HashMap<String,String>();
        type4.put("bsTypeId","4");
        type4.put("bsTypeName","登录属性");

        Map<String, String> type5 = new HashMap<String,String>();
        type5.put("bsTypeId","5");
        type5.put("bsTypeName","自定义属性");   // === pojo(bsTypeId  bsTypeName )
        /*type5.put("1","自定义属性");*/

        List<Map<String, String>> bsType = Arrays.asList(type1, type2, type3, type4, type5);

        //4、采集方式   3位二进制位，分别代表：人工录入、登录采集、远程扫描。0为不支持、1-支持
        ArrayList<String> collectType = new ArrayList();
        collectType.add("001");
        collectType.add("010");
        collectType.add("100");
        collectType.add("011");
        collectType.add("101");
        collectType.add("110");
        collectType.add("111");
        result.put("pageInfo",pageInfo);
        result.put("amPropClasses",amPropClasses);
        result.put("bsType",bsType);
        result.put("collectType",collectType);
        return result;
    }
    /**
     * 绑定属性
     * @param id
     * @return
     */
    public List<AmAssetProp> boundProp(String id) {
        List<AmAssetProp> amAssetProps = amAssetPropMapper.boundProp(id);
        return amAssetProps;
    }

    public Map<String, Object> saveProp(String ids, String pkAssetType) {
        HashMap<String,Object> map = new HashMap();
        try {
            String[] split = ids.split(",");
            for(String id:split){
                AmAssetTypeProp amAssetTypeProp = new AmAssetTypeProp();
                amAssetTypeProp.setPkAssetType(pkAssetType);
                amAssetTypeProp.setPkAssetProp(id);
                Short i=1;
                amAssetTypeProp.setIsView(i);
                amAssetTypeProp.setNeedValue(i);
                amAssetTypeProp.setCollectType("100");
                amAssetTypeProp.setComeFrom(i);
                amAssetTypePropMapper.insert(amAssetTypeProp);
            }
        } catch (Exception e) {
            map.put("code","0");
            e.printStackTrace();
            return map;
        }
            map.put("code","1");
        return map;
    }

    /**
     * 解绑属性
     * @param ids
     * @param pkAssetType
     * @return
     */
    public Map<String, Object> deleteProp(String ids, String pkAssetType) {
        HashMap<String,Object> map = new HashMap();
        try {
            String[] split = ids.split(",");
            for(String id:split){
                AmAssetTypePropExample amAssetTypePropExample = new AmAssetTypePropExample();
                AmAssetTypePropExample.Criteria criteria = amAssetTypePropExample.createCriteria();
                criteria.andPkAssetPropEqualTo(id);
                criteria.andPkAssetTypeEqualTo(pkAssetType);
                amAssetTypePropMapper.deleteByExample(amAssetTypePropExample);
            }
        } catch (Exception e) {
            map.put("code","0");
            e.printStackTrace();
            return map;
        }
        map.put("code","1");
        return map;
    }
    /**
     * 添加属性
     * @param provVO
     * @param value
     */
    public Map<String, Object> addAmAssetProp(ProvVO provVO, String value) {
        Map<String, Object> map=new HashMap<String, Object>();
        try {
            //先存入资产属性表
            AmAssetProp amAssetProp = provVO.getAssetPropBaseInfo();
            String pkAssetProp = PkUtils.getUUID();
            amAssetProp.setPkAssetProp(pkAssetProp);
            Short bsType=4;
            amAssetProp.setBsType(bsType);
            String collectType = amAssetProp.getCollectType();
            String replace = collectType.replace(",", "");
            amAssetProp.setCollectType(replace);
            //加入创建人和最后修改人。。。从Redis数据库中取得
            String pkCreator = redisTemplate.boundHashOps("session").get("token_" + value)+"";
            //创建时间
            Date date = new Date();
            amAssetProp.setCreateTime(date);
            amAssetProp.setMendTimeLast(date);
            //加入创建人和最后修改人
            amAssetProp.setPkCreator(pkCreator);
            amAssetProp.setPkMender(pkCreator);
            int i = amAssetPropMapper.insert(amAssetProp);
            if(i>0){
                //添加成功，清楚Redis中的缓存
                Boolean b = redisTemplate.hasKey("proplist");
                if(b){
                    redisTemplate.delete("proplist");
                }
            }
            //再向属性值域列表添加数据
            List<AmAssetPropValue> assetPropValues = provVO.getAssetPropValues();
            if(amAssetProp.getDataType().equals("E")&&assetPropValues.size()>0){
                for(AmAssetPropValue amAssetPropValue :assetPropValues){
                    amAssetPropValue.setPkAssetPropValue(PkUtils.getUUID());
                    amAssetPropValue.setPkAssetProp(pkAssetProp);
                    amAssetPropValueMapper.insert(amAssetPropValue);
                }
            }
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }
    /**
     * 页面回显数据
     * @param id
     * @return
     */
    public AmAssetProp showAmAssetProp(String id) {
        AmAssetProp amAssetProp = amAssetPropMapper.selectByPrimaryKey(id);
        return amAssetProp;
    }
    /**
     * 编辑属性
     * @param amAssetProp
     */
    public Map<String,Object> updateAmAssetProp(AmAssetProp amAssetProp,String value) {
        Map<String,Object> map = new HashMap();
        //从数据库里取出数据
        AmAssetProp db_amAssetProp = showAmAssetProp(amAssetProp.getPkAssetProp());
        //将前端拿到的数据，替代数据库里的数据
        String propName = amAssetProp.getPropName();
        String propCode = amAssetProp.getPropCode();
        String propDesc = amAssetProp.getPropDesc();
        db_amAssetProp.setPropName(propName);
        db_amAssetProp.setPropCode(propCode);
        db_amAssetProp.setPropDesc(propDesc);
        //从redis里取出修改人的信息
        String  PkMender = redisTemplate.boundHashOps("session").get("token_" + value)+"";
        db_amAssetProp.setPkMender(PkMender);
        db_amAssetProp.setMendTimeLast(new Date());
        int i = amAssetPropMapper.updateByPrimaryKey(db_amAssetProp);
        if(i>0){
            map.put("code",1);
            map.put("msg","修改成功");
            //清理redis中的缓存
            if (i > 0) {
                //添加成功，清楚Redis中的缓存
                Boolean b = redisTemplate.hasKey("proplist");
                if (b) {
                    redisTemplate.delete("proplist");
                }
            }
        }else {
            map.put("code", 0);
            map.put("msg", "修改失败");
        }
        return map;
    }

    /**
     * 删除属性
     * @param id
     * @return
     */
    public Map<String, Object> assetPropDelete(String id) {
        HashMap<String, Object> map = new HashMap();
        //先从数据库查询出对应数据
        AmAssetProp amAssetProp = showAmAssetProp(id);
        Short is_Delete=1;
        amAssetProp.setIsDeleted(is_Delete);
        int i = amAssetPropMapper.updateByPrimaryKey(amAssetProp);
        if(i>0){
            map.put("code", 1);
            map.put("msg", "属性更改成功");
            //清理redis中的缓存
            if (i > 0) {
                //添加成功，清楚Redis中的缓存
                Boolean b = redisTemplate.hasKey("proplist");
                if (b) {
                    redisTemplate.delete("proplist");
                }
            }
        } else {
            map.put("code",0);
            map.put("msg","属性更改失败");
        }
        return map;
    }

    /**
     * 再次查询数据
     * @param id
     * @return
     */
    public List<AmAssetProp> findAgain(String id) {
        List<AmAssetProp> amAssetProps = amAssetPropMapper.findPropListByAssetTypeId(id);
        return amAssetProps;
    }

    /**
     * 根据名称模糊查询
     * @param pkAssetType
     * @param propName
     * @return
     */
    public List<AmAssetProp> assetpropController_searchPropByName(String pkAssetType, String propName) {
        HashMap<String ,String > map = new HashMap();
        map.put("id",pkAssetType);
        map.put("name","%"+propName+"%");
        List<AmAssetProp> amAssetProps = amAssetPropMapper.findPropListByAssetTypeIdAndLikePropName(map);
        return amAssetProps;
    }

    /**
     * 配置页面属性回显
     * @param pkAssetType
     * @param pkAssetProp
     * @return
     */
    public Map<String, Object> assetPropController_configShow(String pkAssetType, String pkAssetProp) {
        Map<String, Object> map=new HashMap<String, Object>();
        //先根据两个id将对应的关联表数据查询出来
        AmAssetTypePropExample amAssetTypePropExample = new AmAssetTypePropExample();
        AmAssetTypePropExample.Criteria criteria = amAssetTypePropExample.createCriteria();
        criteria.andPkAssetTypeEqualTo(pkAssetType);
        criteria.andPkAssetPropEqualTo(pkAssetProp);
        AmAssetTypeProp amAssetTypeProp = amAssetTypePropMapper.selectByExample(amAssetTypePropExample).get(0);
        map.put("amAssetTypeProp",amAssetTypeProp);
        //再根据pkAssetProp将属性表的数据查询出来
        AmAssetProp amAssetProp = amAssetPropMapper.selectByPrimaryKey(pkAssetProp);
        map.put("amAssetProp",amAssetProp);
        return map;
    }

    /**
     * 配置修改
     * @param amAssetTypeProp
     * @return
     */
    public Map<String, Object> assetpropController_change(AmAssetTypeProp amAssetTypeProp) {
        Map<String, Object> map=new HashMap<String, Object>();
        AmAssetTypePropExample amAssetTypePropExample = new AmAssetTypePropExample();
        AmAssetTypePropExample.Criteria criteria = amAssetTypePropExample.createCriteria();
        criteria.andPkAssetPropEqualTo(amAssetTypeProp.getPkAssetProp());
        criteria.andPkAssetTypeEqualTo(amAssetTypeProp.getPkAssetType());
        AmAssetTypeProp db_assetTypeProp = amAssetTypePropMapper.selectByExample(amAssetTypePropExample).get(0);
        db_assetTypeProp.setIsView(amAssetTypeProp.getIsView());
        db_assetTypeProp.setNeedValue(amAssetTypeProp.getNeedValue());
        db_assetTypeProp.setCollectType(amAssetTypeProp.getCollectType().replace(",",""));
        int i = amAssetTypePropMapper.updateByPrimaryKey(db_assetTypeProp);
        if(i>0){
            map.put("code",1);
        }else{
            map.put("code",0);
        }
        return map;
    }

    /**
     * 多个条件查询属性
     * @param amAssetProp
     * @return
     */
    public List<AmAssetProp> queryProp(AmAssetProp amAssetProp) {
        AmAssetPropExample amAssetPropExample = new AmAssetPropExample();
        AmAssetPropExample.Criteria criteria = amAssetPropExample.createCriteria();
        criteria.andBsTypeEqualTo(amAssetProp.getBsType());
        criteria.andPkPropClassEqualTo(amAssetProp.getPkPropClass());
        criteria.andCollectTypeEqualTo(amAssetProp.getCollectType());
        criteria.andPropNameLike("%"+amAssetProp.getPropName()+"%");
        List<AmAssetProp> amAssetProps = amAssetPropMapper.selectByExample(amAssetPropExample);
        return amAssetProps;
    }

}
