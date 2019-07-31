package com.ultrapower.service;

import com.ultrapower.dao.*;
import com.ultrapower.pojo.*;
import com.ultrapower.util.PkUtils;
import com.ultrapower.util.StringToDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
public class AmAssetTypeServiceImpl implements AmAssetTypeService {
    @Autowired
    AmAssetTypePropMapper amAssetTypePropMapper;
    @Autowired
    AmAssetTypeMapper amAssetTypeMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    AmAssetPropMapper amAssetPropMapper;
    @Autowired
    AmBsProvMapper amBsProvMapper;
    @Autowired
    AmAssetMapper amAssetMapper;
    @Autowired
    AmAssetExtendPropMapper amAssetExtendPropMapper;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    AmAssetPortCollectMapper amAssetPortCollectMapper;
    /**
     * es高级搜索
     * @param id
     * @return
     */
    public Map<String, Object> queryAllAssetByAssetPk(String id) {
        //资产主表
        Map<String, Object> map=new HashMap<String, Object>();
        List<QueryAssetVO> queryAssetVOS = amAssetMapper.queryAllAssetByAssetPk(id);
        map.put("queryAssetVO",null);
        if(queryAssetVOS!=null&&queryAssetVOS.size()>0){
            QueryAssetVO queryAssetVO = queryAssetVOS.get(0);
            map.put("queryAssetVO",queryAssetVO);
        }
        //资产扩展表
        AmAssetExtendProp amAssetExtendProp = amAssetExtendPropMapper.selectByPrimaryKey(id);
        map.put("amAssetExtendProp",amAssetExtendProp);
        //端口信息
        AmAssetPortCollectExample amAssetPortCollectExample = new AmAssetPortCollectExample();
        AmAssetPortCollectExample.Criteria criteria = amAssetPortCollectExample.createCriteria();
        criteria.andPkAssetEqualTo(id);
        List<AmAssetPortCollect> amAssetPortCollects = amAssetPortCollectMapper.selectByExample(amAssetPortCollectExample);
        map.put("amAssetPortCollects",amAssetPortCollects);
        return map;
    }

    public Map<String, Object> changeAssetStateOff(String id) {
        Map<String, Object> map=new HashMap<String, Object>();
        try {
            AmAsset amAsset = amAssetMapper.selectByPrimaryKey(id);
            Short assetState=4;
            amAsset.setAssetState(assetState);
            amAssetMapper.updateByPrimaryKey(amAsset);
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    public Map<String, Object> changeAssetStateOn(String id) {
        Map<String, Object> map=new HashMap<String, Object>();
        try {
            AmAsset amAsset = amAssetMapper.selectByPrimaryKey(id);
            Short assetState=2;
            amAsset.setAssetState(assetState);
            amAssetMapper.updateByPrimaryKey(amAsset);
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 编辑资产
     * @param addAssetVO
     * @return
     */
    public Map<String, Object> editAsset(AddAssetVO addAssetVO) {
        Map<String, Object> map=new HashMap<String, Object>();
        try {
            AmAsset amAsset = addAssetVO.getAsset();
            //将数据更新到资产表中
            amAssetMapper.updateByPrimaryKey(amAsset);
            //assetExtendProp更新扩展数据表
            AmAssetExtendProp assetExtendProp = addAssetVO.getAssetExtendProp();
            amAssetExtendPropMapper.updateByPrimaryKey(assetExtendProp);
            //将PropValue以更新存入mongodb中
            List<VueVO> props = addAssetVO.getProps();
            for(VueVO vueVO:props){
                Query query = new Query();
                query.addCriteria(Criteria.where("_id").is(vueVO.getId()));
                Update update = new Update();
                update.set("pkAsset",vueVO.getPkAsset());
                update.set("pkAssetProp",vueVO.getPkAssetProp());
                update.set("propName",vueVO.getPropName());
                update.set("dataType",vueVO.getDataType());
                update.set("propValue",vueVO.getPropValue());
                update.set("list",vueVO.getList());
                mongoTemplate.updateFirst(query,update,VueVO.class);
            }
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 编辑资产页面数据回显
     * @param id
     * @return
     */
    public Map<String, Object> showAssetAagin(String id) {
        Map<String, Object> map=new HashMap();
       /* private AmAsset asset;
        private List<VueVO> props;
        private AmAssetExtendProp assetExtendProp;*/
        AmAsset amAsset = amAssetMapper.selectByPrimaryKey(id);
        AmAssetExtendProp amAssetExtendProp = amAssetExtendPropMapper.selectByPrimaryKey(id);
        //从mongodb查询出数据
        Query query = new Query();
        query.addCriteria(Criteria.where("pkAsset").is(id));
        List<VueVO> props = mongoTemplate.find(query, VueVO.class);
        map.put("asset",amAsset);
        map.put("props",props);
        map.put("assetExtendProp",amAssetExtendProp);
        return map;
    }

    public List<VueVO> showAllBoundprop(String pkAssetType) {
        List<VueVO> amAssetProps = amAssetPropMapper.showAllBoundprop(pkAssetType);
        return amAssetProps;
    }

    public Map<String, Object> addAsset(AddAssetVO addAssetVO) {
        Map<String, Object> map=new HashMap<String, Object>();
        try {
            AmAsset amAsset = addAssetVO.getAsset();
            //将数据添加到资产表中
            String pkAsset = PkUtils.getUUID();
            amAsset.setPkAsset(pkAsset);
            Short s=1;
            amAsset.setComeFrom(s);
            amAsset.setProvCode("HB");
            amAsset.setAssetState(s);
            amAssetMapper.insert(amAsset);
            //assetExtendProp存入扩展数据表
            AmAssetExtendProp assetExtendProp = addAssetVO.getAssetExtendProp();
            assetExtendProp.setPkAsset(pkAsset);
            amAssetExtendPropMapper.insert(assetExtendProp);
            //将PropValue以文档的形式存入mongodb中
            List<VueVO> props = addAssetVO.getProps();
            for(VueVO vueVO:props){
                vueVO.setPkAsset(pkAsset);
                mongoTemplate.insert(vueVO);
            }
            map.put("pkAsset",pkAsset);
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 添加资产页面数据显示
     * @return
     */
    public Map<String, Object> showAssetMsg() {
        Map<String, Object> map=new HashMap<String, Object>();
        //显示资产类型下拉框
        List<AmAssetType> allAmAssetType = findAllAmAssetType();
        map.put("allAmAssetType",allAmAssetType);
        //显示所有省份业务系统
        List<AmBsProv> amBsProvs = amBsProvMapper.selectByExample(null);
        map.put("amBsProvs",amBsProvs);
        return map;
    }

    public List<AmAssetType> findAllAmAssetType() {
       List<AmAssetType> amAssetTypes = amAssetTypeMapper.findTypeAndUser();
       return amAssetTypes;
   }
    public List<Nodes> sortAllAmAsset() {
        List<Nodes> nodesList = new ArrayList();
        List<AmAssetDTO> list = amAssetTypeMapper.sortAllAmAsset();
        for (int i = 0; i < list.size(); i++) {
            //一级树
            Nodes one = new Nodes();
            AmAssetDTO amAssetDTO = list.get(i);
            one.setId((i + 1) + "");
            one.setName(amAssetDTO.getName());
            one.setpId(0 + "");
            nodesList.add(one);
            if (amAssetDTO.getSecondType().size() == 0) {
                Nodes two = new Nodes();
                two.setId((i + 1) * 100 + "");
                two.setName("暂无");
                two.setpId((i + 1) + "");
                nodesList.add(two);
            }
            for (int j = 0; j < amAssetDTO.getSecondType().size(); j++) {
                //二级树
                Nodes two = new Nodes();
                two.setId(((i + 1) * 100 + j) + "");
                two.setName(amAssetDTO.getSecondType().get(j).getName());
                two.setpId((i + 1) + "");
                nodesList.add(two);
            }
        }
        return nodesList;
    }
    public List<AmAssetType> findAllAmAssetTypeByName(String name){
        AmAssetTypeExample amAssetTypeExample = new AmAssetTypeExample();
        AmAssetTypeExample.Criteria criteria = amAssetTypeExample.createCriteria();
        criteria.andTypeNameEqualTo(name);
        List<AmAssetType> amAssetTypes = amAssetTypeMapper.selectByExample(amAssetTypeExample);
        return amAssetTypes;
    }

    /**
     * 根据日期查询信息
     * @param queryVO
     * @return
     */
    public List<AmAssetType> findAllAmAssetTypeByCondition(QueryVO queryVO) {
        AmAssetTypeExample amAssetTypeExample = new AmAssetTypeExample();
        AmAssetTypeExample.Criteria criteria = amAssetTypeExample.createCriteria();
        //将yyyy-MM-dd转化为日期类型
        criteria.andCreateTimeBetween(StringToDateUtils.StringToDate(queryVO.getBeginTime()),StringToDateUtils.StringToDate(queryVO.getEndTime()));
        criteria.andTypeNameLike("%"+queryVO.getKeywords()+"%");
        List<AmAssetType> amAssetTypes = amAssetTypeMapper.selectByExample(amAssetTypeExample);
        return amAssetTypes;
    }

    /**
     * 查询所有一级网络资产
     * @return
     */
    public List<AmAssetType> findAllFirstType() {
        //条件1：IS_DELETED=0  and IS_VIEW=1
        // 条件2：必须一级分类节点
        AmAssetTypeExample amAssetTypeExample = new AmAssetTypeExample();
        AmAssetTypeExample.Criteria criteria = amAssetTypeExample.createCriteria();
        Short IS_VIEW = 1;
        Short IS_DELETED = 0;
        criteria.andIsDeletedEqualTo(IS_DELETED);
        criteria.andIsViewEqualTo(IS_VIEW);
        criteria.andPkTypeParentIsNull();
        List<AmAssetType> amAssetTypes = amAssetTypeMapper.selectByExample(amAssetTypeExample);
        return amAssetTypes;
    }

    /**
     * 新增网络资产
     * @param amAssetType
     * @param cookie
     * @return
     */
    public int addAmAssetType(AmAssetType amAssetType, String cookie) {
        //typeName  typeCode  pkTypeParent  typeDesc
        amAssetType.setTypeName(amAssetType.getTypeName());
        amAssetType.setPkAssetType(PkUtils.getUUID());
        amAssetType.setPkTypeParent(amAssetType.getPkTypeParent().equals("root")?null:amAssetType.getPkTypeParent());
        Short is_view = 1 ;
        Short is_delete = 0 ;
        Short comeFrom=0;
        amAssetType.setIsView(is_view);
        amAssetType.setIsDeleted(is_delete);
        amAssetType.setComeFrom(comeFrom);
        //创建时间
        Date date = new Date();
        amAssetType.setCreateTime(date);
        amAssetType.setMendTimeLast(date);
        //加入创建人和最后修改人
        amAssetType.setPkCreator(cookie);
        amAssetType.setPkMender(cookie);
        int i = amAssetTypeMapper.insert(amAssetType);
        return i;
    }

    /**
     * 根据ID查询指定资产
     * @param id
     * @return
     */
    public AmAssetType findAmAssetTypeById(String id) {
        AmAssetType amAssetType = amAssetTypeMapper.selectByPrimaryKey(id);
        return amAssetType;
    }

    public void updateAssetType(AmAssetType amAssetType,String value){
        //先根据id从数据库查询出对应资产
        AmAssetType db_amAssetType = findAmAssetTypeById(amAssetType.getPkAssetType());
        String typeName=amAssetType.getTypeName();
        String typeCode=amAssetType.getTypeCode();
        String typeDesc=amAssetType.getTypeDesc();
        String pkTypeParent=amAssetType.getPkTypeParent();
        //对数据进行更新
        db_amAssetType.setTypeName(typeName);
        db_amAssetType.setTypeCode(typeCode);
        db_amAssetType.setTypeDesc(typeDesc);
        db_amAssetType.setPkTypeParent(pkTypeParent.equals("root")?null:pkTypeParent);
        //修改最后修改人和时间,从redis数据库中取操作人Id
        db_amAssetType.setMendTimeLast(new Date());
        String session = redisTemplate.boundHashOps("session").get("token_" + value)+"";
        db_amAssetType.setPkMender(session);
        //存入数据库
        amAssetTypeMapper.updateByPrimaryKey(db_amAssetType);
    }

    /**
     * 隐藏数据
     * @param id
     * @return
     */
    public int deleteAssetType(String id) {
        //先将数据从数据库查询出来
        AmAssetType amAssetType = findAmAssetTypeById(id);
        Short isDeleted=1;
        amAssetType.setIsDeleted(isDeleted);
        //再更新数据
        int i = amAssetTypeMapper.updateByPrimaryKey(amAssetType);
        return i;
    }

    public Map<String,Object> deleteAssetTypeByIds(String ids) {
        String[] split = ids.split(",");
        Map<String,Object> map = new HashMap();
        try {
            for(String id:split){
                deleteAssetType(id);
            }
            map.put("code",1);
            map.put("msg","删除成功");
        } catch (Exception e) {
            map.put("code",0);
            map.put("msg","删除失败");
            e.printStackTrace();
        }
        return map;
    }
    /**
     * 资产类型列表页面详情
     * @param name
     * @return
     */
    public Map<String, Object> findAmAssetTypeAndPropListByName(String name, HttpServletResponse response) {
        Map<String, Object> map = new HashMap();
        //先根据名字查询出数据
        List<AmAssetType> allAmAssetTypeByName = findAllAmAssetTypeByName(name);
        AmAssetType amAssetType=allAmAssetTypeByName.get(0);
        //再从数据中拿到Id
        String pkAssetType = amAssetType.getPkAssetType();
        //将指定Id存放到Cookie
        Cookie cookie = new Cookie("pkAssetType", pkAssetType);
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        //向浏览器存放Cookie
        response.addCookie(cookie);
        List<AmAssetProp> amAssetProp = amAssetPropMapper.findPropListByAssetTypeId(pkAssetType);
        map.put("amAssetType",amAssetType);
        map.put("amAssetProp",amAssetProp);
        return map;
    }
}
