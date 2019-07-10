package com.ultrapower.dao;

import com.ultrapower.pojo.AmAsset;
import com.ultrapower.pojo.AmAssetExample;
import com.ultrapower.pojo.AmAssetQuery;
import com.ultrapower.pojo.QueryAssetVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AmAssetMapper {
    int countByExample(AmAssetExample example);

    int deleteByExample(AmAssetExample example);

    int deleteByPrimaryKey(String pkAsset);

    int insert(AmAsset record);

    int insertSelective(AmAsset record);

    List<AmAsset> selectByExample(AmAssetExample example);

    AmAsset selectByPrimaryKey(String pkAsset);

    int updateByExampleSelective(@Param("record") AmAsset record, @Param("example") AmAssetExample example);

    int updateByExample(@Param("record") AmAsset record, @Param("example") AmAssetExample example);

    int updateByPrimaryKeySelective(AmAsset record);

    int updateByPrimaryKey(AmAsset record);

    List<AmAssetQuery> showUnboundAsset(Map<String,Object> map);

    List<AmAssetQuery> showAllAsset();

    List<QueryAssetVO> queryAllAssetByAssetPk(String id);

}