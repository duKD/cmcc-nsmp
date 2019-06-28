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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
public class AmBsGroupServiceImpl implements AmBsGroupService {
    @Autowired
    AmBsGroupMapper amBsGroupMapper;
    @Autowired
    AmBsGroupProvMapper amBsGroupProvMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    AmBsProvMapper amBsProvMapper;
    @Autowired
    BdmProvMapper bdmProvMapper;
    @Autowired
    AmAssetTypeMapper amAssetTypeMapper;
    /**
     * 集团业务树
     * @return
     */
    public List<Nodes> sortAllAmBs() {
        List<AmBsDTO> amBsDTOS = amBsGroupMapper.sortAllAmBs();
        List<Nodes> nodesList = new ArrayList();
        for (int i = 0; i < amBsDTOS.size(); i++) {
            //遍历一级树
            Nodes one = new Nodes();
            one.setpId(0+"");
            one.setId((i+1)+"");
            AmBsDTO amBsDTO = amBsDTOS.get(i);
            one.setName(amBsDTO.getName());
            nodesList.add(one);
            if (amBsDTO.getNextAmBs().size() == 0) {
                //当没有子节点时，给它个默认值暂无
                Nodes two = new Nodes();
                two.setId((i + 1) * 100 + "");
                two.setpId((i+1)+"");
                two.setName("暂无");
                nodesList.add(two);
            }
            List<AmBsDTO> sencondAmBs = amBsDTO.getNextAmBs();
            for(int j=0;j<sencondAmBs.size();j++){
                //遍历二级树
                Nodes two = new Nodes();
                two.setpId((i+1)+"");
                two.setId(((i+1)*100+j)+"");
                AmBsDTO secondAmBsDTO = sencondAmBs.get(j);
                two.setName(secondAmBsDTO.getName());
                nodesList.add(two);
                if(secondAmBsDTO.getNextAmBs().size()==0){
                    //当没有子节点时，给它个默认值暂无
                    Nodes three = new Nodes();
                    three.setId((j+1)*10000+"");
                    three.setpId(((i+1)*100+j)+"");
                    three.setName("暂无");
                    nodesList.add(three);
                }
                List<AmBsDTO> threeAmBsDTO = secondAmBsDTO.getNextAmBs();
                for(int k=0;k<threeAmBsDTO.size();k++){
                    //遍历三级树
                    Nodes three = new Nodes();
                    three.setId(((j+1)*10000+k)+"");
                    three.setpId(((i+1)*100+j)+"");
                    three.setName(threeAmBsDTO.get(k).getName());
                    nodesList.add(three);
                }
            }
        }
        return nodesList;
    }
    /**
     * 页面所有数据显示
     * @param
     * @return
     */
    public Map<String, Object> pageDatashow(String name, HttpServletResponse response,int pageNum,int pageSize) {
        Map<String, Object> map= new HashMap<String, Object>();
        AmBsGroup amBsGroup = findAmBsGroupByName(name, response);
        String pkBsGroup=amBsGroup.getPkBsGroup();
        List<BsResultDTO> bsResultDTOS = showConnectProv(pkBsGroup);
        PageInfo<BsGroupConnectAsset> pageInfo = showConnectAsset(pkBsGroup, pageNum, pageSize);
        List<BdmProv> bdmProvs = showBdmProv();
        List<AmAssetType> amAssetTypes = amAssetTypeMapper.selectByExample(null);
        map.put("amBsGroup",amBsGroup);
        map.put("bsResultDTOS",bsResultDTOS);
        map.put("pageInfo",pageInfo);
        map.put("bdmProvs",bdmProvs);
        map.put("amAssetTypes",amAssetTypes);
        return map;
    }
    /**
     * 根据集团系统业务查询数据
     * @param name
     * @return
     */
    public AmBsGroup findAmBsGroupByName(String name, HttpServletResponse response) {
        AmBsGroupExample amBsGroupExample = new AmBsGroupExample();
        AmBsGroupExample.Criteria criteria = amBsGroupExample.createCriteria();
        criteria.andBsNameEqualTo(name);
        AmBsGroup amBsGroup = amBsGroupMapper.selectByExample(amBsGroupExample).get(0);
        String pkBsParent = amBsGroup.getPkBsParent();
        if(pkBsParent!=null){
            //根据上级id拿到名字
            AmBsGroupExample amBsGroupExample1 = new AmBsGroupExample();
            AmBsGroupExample.Criteria criteria1 = amBsGroupExample1.createCriteria();
            criteria1.andPkBsGroupEqualTo(pkBsParent);
            List<AmBsGroup> amBsGroups = amBsGroupMapper.selectByExample(amBsGroupExample1);
            if(amBsGroups.size()>0){
                AmBsGroup amBsGroup1 = amBsGroups.get(0);
                String bsName = amBsGroup1.getBsName();
                amBsGroup.setPkBsParent(bsName);
            }
        }
        //向Cookie中存入集团业务id
        String pkBsGroup = amBsGroup.getPkBsGroup();
        Cookie cookie = new Cookie("pkBsGroup", pkBsGroup);
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        response.addCookie(cookie);
        return amBsGroup;
    }
    /**
     * 关联省级系统业务
     * @param id
     * @return
     */
    public List<BsResultDTO> showConnectProv(String id) {
        List<BsResultDTO> bsResultDTO = amBsGroupMapper.showConnectProv(id);
        return bsResultDTO;
    }
    /**
     * 删除集团业务系统映射的省级业务系统
     * @return
     */
    public Map<String,Object> deleteAmBsGroupProv(String pkBsGroup,String pkBsProv){
        Map<String,Object> map = new HashMap();
        AmBsGroupProvExample amBsGroupProvExample = new AmBsGroupProvExample();
        AmBsGroupProvExample.Criteria criteria = amBsGroupProvExample.createCriteria();
        criteria.andPkBsGroupEqualTo(pkBsGroup);
        criteria.andPkBsProvEqualTo(pkBsProv);
        int i = amBsGroupProvMapper.deleteByExample(amBsGroupProvExample);
        if(i>0){
            map.put("code",1);
            map.put("msg","删除成功");
        }else{
            map.put("code",0);
            map.put("msg","删除失败");
        }
        return map;
    }
    /**
     * 添加集团业务系统
     * @param amBsGroup
     * @return
     */
    public Map<String,Object> addAmBsGroup(AmBsGroup amBsGroup,String pkBsGroup,String value){
        Map<String,Object> map=new HashMap<String, Object>();
        //先向集团业务表添加，使用amBsGroup,pkBsGroup(上级id)数据
        amBsGroup.setPkBsParent(pkBsGroup);
         //利用UUID生成pkBsGroup
        String uuid = PkUtils.getUUID();
        amBsGroup.setPkBsGroup(uuid);
        Short isDeleted=0;
        amBsGroup.setIsDeleted(isDeleted);
        //添加创建人和最后修改人，从Redis中取出User的PkNsmpUser
        String PkNsmpUser = redisTemplate.boundHashOps("seesion").get("token_" + value)+"";
        amBsGroup.setPkCreator(PkNsmpUser);
        amBsGroup.setPkMender(PkNsmpUser);
        //创建时间和最后修改时间
        Date date = new Date();
        amBsGroup.setCreateTime(date);
        amBsGroup.setMendTimeLast(date);
        int i = amBsGroupMapper.insert(amBsGroup);
        //再向关联表中添加集团与省份系统的id
        AmBsGroupProv amBsGroupProv = new AmBsGroupProv();
        //加入主键
        amBsGroupProv.setPkBsGroupProv(PkUtils.getUUID());
        //加入集团系统的id
        amBsGroupProv.setPkBsGroup(pkBsGroup);
        //加入映射表中对应的省份系统id

        //加入创建人和创建时间
        amBsGroupProv.setPkCreator(PkNsmpUser);
        amBsGroupProv.setCreateTime(date);
        int j = amBsGroupProvMapper.insert(amBsGroupProv);
        if(i>0&&j>0){
            map.put("code",1);
        }else{
            map.put("code",0);
        }
        return map;
    }

    /**
     * 编辑集团业务系统
     * @param amBsGroup
     * @param pkBsGroup
     * @param value
     * @return
     */
    public Map<String, Object> editAMBsGroup(AmBsGroup amBsGroup, String pkBsGroup, String value) {
        Map<String,Object> map=new HashMap<String, Object>();
        //先向数据库查询出该数据，再进行修改
        AmBsGroup db_amBsGroup  = amBsGroupMapper.selectByPrimaryKey(amBsGroup.getPkBsGroup());
        db_amBsGroup.setBsName(amBsGroup.getBsName());
        db_amBsGroup.setBsCode(amBsGroup.getBsCode());
        //显示顺序

        //业务系统描述
        db_amBsGroup.setBsDesc(amBsGroup.getBsDesc());

        //添加最后修改人，从Redis中取出User的PkNsmpUser
        String PkNsmpUser = redisTemplate.boundHashOps("seesion").get("token_" + value)+"";
        db_amBsGroup.setPkMender(PkNsmpUser);
        //最后修改时间
        Date date = new Date();
        amBsGroup.setMendTimeLast(date);
        int i = amBsGroupMapper.insert(amBsGroup);
        //再向关联表中添加集团与省份系统的id
        AmBsGroupProv amBsGroupProv = new AmBsGroupProv();
        //加入主键
        amBsGroupProv.setPkBsGroupProv(PkUtils.getUUID());
        //加入集团系统的id
        amBsGroupProv.setPkBsGroup(pkBsGroup);
        //加入映射表中对应的省份系统id

        //加入创建人和创建时间
        amBsGroupProv.setPkCreator(PkNsmpUser);
        amBsGroupProv.setCreateTime(date);
        int j = amBsGroupProvMapper.insert(amBsGroupProv);
        if(i>0&&j>0){
            map.put("code",1);
        }else{
            map.put("code",0);
        }
        return map;
    }

    /**
     * 编辑集团业务系统数据回显
     * @param pkBsGroup
     * @return
     */
    public AmBsGroup showAmBsGroup(String pkBsGroup) {
        //根据id从数据库获得数据b
        AmBsGroup amBsGroup = amBsGroupMapper.selectByPrimaryKey(pkBsGroup);
        return amBsGroup;
    }
    /**
     * 删除集团系统业务
     * @param pkBsGroup
     * @return
     */
    public Map<String, Object> deleteAmBsGroup(String pkBsGroup) {
        //需先判断，该业务系统下还有子节点时，不可删除

        return null;
    }

    /**
     * 手动映射省级业务系统之未映射数据回显
     * @param pkBsGroup
     * @return
     */
    public List<AmBsProv> showUnboundProv(String provCode,String pkBsGroup) {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("pkBsGroup",pkBsGroup);
        hashMap.put("provCode",provCode);
        List<AmBsProv> amBsProvs = amBsProvMapper.showUnboundProv(hashMap);
        return amBsProvs;
    }

    /**
     *手动映射省级业务系统
     * @param pkBsGroup
     * @param pkBsProv
     * @return
     */
    public Map<String ,Object>  boundProv(String pkBsGroup, String pkBsProv, String value) {
        Map<String ,Object> map=new HashMap<String ,Object>();
        try {
            //先从redis中取出创建人
            String pkCreator= redisTemplate.boundHashOps("session").get("token_" + value)+"";
            String[] split = pkBsProv.split(",");
            for(String id:split){
                AmBsGroupProv amBsGroupProv = new AmBsGroupProv();
                //先获得id主键
                String uuid = PkUtils.getUUID();
                amBsGroupProv.setPkBsGroupProv(uuid);
                amBsGroupProv.setPkCreator(pkCreator);
                amBsGroupProv.setCreateTime(new Date());
                amBsGroupProv.setPkBsGroup(pkBsGroup);
                amBsGroupProv.setPkBsProv(id);
                Short matchType=1;
                amBsGroupProv.setMatchType(matchType);
                amBsGroupProvMapper.insert(amBsGroupProv);
            }
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        List<BsResultDTO> bsResultDTOS = showConnectProv(pkBsGroup);
        map.put("bsResultDTOS",bsResultDTOS);
        return map;
    }

    /**
     * 资产属性展示
     * @param id
     * @return
     */
    public PageInfo<BsGroupConnectAsset> showConnectAsset(String id,int pageNum,int pageSize) {
        AssetQueryVO assetQueryVO = new AssetQueryVO();
        assetQueryVO.setPkBsGroup(id);
        PageHelper.startPage(pageNum, pageSize);
        List<BsGroupConnectAsset> bsGroupConnectAssets = amBsGroupMapper.showConnectAsset(assetQueryVO);
        PageInfo<BsGroupConnectAsset> pageInfo = new PageInfo<BsGroupConnectAsset>(bsGroupConnectAssets);
        return pageInfo;
    }
    /**
     * 根据省份正则映射省份业务
     * @param provRegex
     * @return
     */
    public List<AmBsProv> bsGroupProvMappingByProvRegex(String provRegex) {
        List<AmBsProv> amBsProvs = amBsProvMapper.bsGroupProvMappingByProvRegex("%"+provRegex+"%");
        return amBsProvs;
    }

    /**
     * 添加集团业务
     * @param amGroupAddDTO
     * @param pkBsGroup
     * @param value
     * @return
     */
    public Map<String, Object> bsGroupAdd(AmGroupAddDTO amGroupAddDTO, String pkBsGroup, String value) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //先将数据添加集团业务表
            AmBsGroup amBsGroup = new AmBsGroup();
            amBsGroup.setPkBsGroup(PkUtils.getUUID());
            amBsGroup.setBsName(amGroupAddDTO.getBsName());
            amBsGroup.setBsCode(amGroupAddDTO.getBsCode());
            amBsGroup.setBsDesc(amGroupAddDTO.getBsDesc());
            amBsGroup.setMappingRegex(amGroupAddDTO.getMappingRegex());
            amBsGroup.setPkBsParent(pkBsGroup);
            Short s = 1; //手动录入
            amBsGroup.setBsSrc(s);
            Short d = 0;//未删除
            amBsGroup.setIsDeleted(d);
            String pkCreator = redisTemplate.boundHashOps("session").get("token_" + value) + "";
            amBsGroup.setPkCreator(pkCreator);
            amBsGroup.setCreateTime(new Date());
            amBsGroup.setPkMender(pkCreator);
            amBsGroup.setMendTimeLast(new Date());
            int i = amBsGroupMapper.insert(amBsGroup);
            if(i>0){
                //再将数据加入关联表
                String[] provIds = amGroupAddDTO.getProvIds().split(",");
                reSet(amBsGroup, provIds, pkCreator);
                map.put("code",1);
            }
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除集团业务
     * @param pkBsGroup
     * @return
     */
    public Map<String, Object> deleteGroup(String pkBsGroup) {
        Map<String, Object> map=new HashMap();
        try {
            //先删除集团业务表中的数据
            AmBsGroupExample amBsGroupExample = new AmBsGroupExample();
            AmBsGroupExample.Criteria criteria = amBsGroupExample.createCriteria();
            criteria.andPkBsGroupEqualTo(pkBsGroup);
            AmBsGroup amBsGroup= amBsGroupMapper.selectByExample(amBsGroupExample).get(0);
           /* short isDelete=1;
            amBsGroup.setIsDeleted(isDelete);
            amBsGroupMapper.updateByPrimaryKey(amBsGroup);*/
           amBsGroupMapper.deleteByPrimaryKey(amBsGroup.getPkBsGroup());
            //再删除关联表中的数据
            AmBsGroupProvExample amBsGroupProvExample = new AmBsGroupProvExample();
            AmBsGroupProvExample.Criteria criteria1 = amBsGroupProvExample.createCriteria();
            criteria1.andPkBsGroupEqualTo(pkBsGroup);
            List<AmBsGroupProv> amBsGroupProvs = amBsGroupProvMapper.selectByExample(amBsGroupProvExample);
            for(AmBsGroupProv amBsGroupProv:amBsGroupProvs){
                amBsGroupProvMapper.deleteByPrimaryKey(amBsGroupProv.getPkBsGroupProv());
            }
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    public List<BdmProv> showBdmProv() {
        List<BdmProv> bdmProvs = bdmProvMapper.selectByExample(null);
        return bdmProvs;
    }

    /**
     * 重新映射
     * @param amGroupAddDTO
     * @param pkBsGroup
     * @param value
     * @return
     */
    public Map<String, Object> bsGroupAddAgain(AmGroupAddDTO amGroupAddDTO, String pkBsGroup, String value) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            //先更新集团业务表
            AmBsGroup amBsGroup = amBsGroupMapper.selectByPrimaryKey(pkBsGroup);
            amBsGroup.setMappingRegex(amGroupAddDTO.getMappingRegex());
            int i = amBsGroupMapper.updateByPrimaryKey(amBsGroup);
            if(i>0){
                //再删除关联表中的数据
                AmBsGroupProvExample amBsGroupProvExample = new AmBsGroupProvExample();
                AmBsGroupProvExample.Criteria criteria = amBsGroupProvExample.createCriteria();
                criteria.andPkBsGroupEqualTo(pkBsGroup);
                amBsGroupProvMapper.deleteByExample(amBsGroupProvExample);
            }
            //最后向关联表中添加数据
            String[] provIds = amGroupAddDTO.getProvIds().split(",");
            String pkCreator = redisTemplate.boundHashOps("session").get("token_" + value) + "";
            reSet(amBsGroup, provIds, pkCreator);
            map.put("code",1);
        } catch (Exception e) {
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 向关联表中添加数据
     * @param amBsGroup
     * @param provIds
     * @param pkCreator
     */
    private void reSet(AmBsGroup amBsGroup, String[] provIds, String pkCreator) {
        for (String pkBsProv : provIds) {
            AmBsGroupProv bsGroupProv = new AmBsGroupProv();
            bsGroupProv.setPkBsGroupProv(PkUtils.getUUID());
            bsGroupProv.setPkBsGroup(amBsGroup.getPkBsGroup());
            bsGroupProv.setPkBsProv(pkBsProv);
            //0-自动映射
            Short m = 0;
            bsGroupProv.setMatchType(m);
            bsGroupProv.setPkCreator(pkCreator);
            bsGroupProv.setCreateTime(new Date());
            amBsGroupProvMapper.insert(bsGroupProv);
        }
    }

    /**
     * 条件查询 ，资产
     * @param assetQueryVO
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<BsGroupConnectAsset> showConnectAssetByCondition(AssetQueryVO assetQueryVO,int pageNum,int pageSize) {
        String assetName = assetQueryVO.getAssetName();
        assetQueryVO.setAssetName("%"+assetName+"%");
        PageHelper.startPage(pageNum, pageSize);
        List<BsGroupConnectAsset> bsGroupConnectAssets = amBsGroupMapper.showConnectAsset(assetQueryVO);
        PageInfo<BsGroupConnectAsset> pageInfo = new PageInfo<BsGroupConnectAsset>(bsGroupConnectAssets);
        return pageInfo;
    }
}
