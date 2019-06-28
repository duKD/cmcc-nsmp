package com.ultrapower.dao;

import com.ultrapower.pojo.AmAssetDTO;
import com.ultrapower.pojo.AmAssetType;
import com.ultrapower.pojo.AmAssetTypeExample;
import com.ultrapower.pojo.testPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AmAssetTypeMapper {
    int countByExample(AmAssetTypeExample example);

    int deleteByExample(AmAssetTypeExample example);

    int deleteByPrimaryKey(String pkAssetType);

    int insert(AmAssetType record);

    int insertSelective(AmAssetType record);

    List<AmAssetType> selectByExample(AmAssetTypeExample example);

    List<AmAssetType> selectByExamplePortion(AmAssetTypeExample example);

    AmAssetType selectByPrimaryKey(String pkAssetType);

    int updateByExampleSelective(@Param("record") AmAssetType record, @Param("example") AmAssetTypeExample example);

    int updateByExample(@Param("record") AmAssetType record, @Param("example") AmAssetTypeExample example);

    int updateByPrimaryKeySelective(AmAssetType record);

    int updateByPrimaryKey(AmAssetType record);

    List<AmAssetDTO> sortAllAmAsset();

    List<AmAssetType>  findTypeAndUser();

    List<testPojo>  showAsset();
}