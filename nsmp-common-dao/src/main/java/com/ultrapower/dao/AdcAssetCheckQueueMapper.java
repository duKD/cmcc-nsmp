package com.ultrapower.dao;

import com.ultrapower.pojo.AdcAssetCheckQueue;
import com.ultrapower.pojo.AdcAssetCheckQueueExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdcAssetCheckQueueMapper {
    int countByExample(AdcAssetCheckQueueExample example);

    int deleteByExample(AdcAssetCheckQueueExample example);

    int deleteByPrimaryKey(String pkAssetCheckQueue);

    int insert(AdcAssetCheckQueue record);

    int insertSelective(AdcAssetCheckQueue record);

    List<AdcAssetCheckQueue> selectByExampleWithBLOBs(AdcAssetCheckQueueExample example);

    List<AdcAssetCheckQueue> selectByExample(AdcAssetCheckQueueExample example);

    AdcAssetCheckQueue selectByPrimaryKey(String pkAssetCheckQueue);

    int updateByExampleSelective(@Param("record") AdcAssetCheckQueue record, @Param("example") AdcAssetCheckQueueExample example);

    int updateByExampleWithBLOBs(@Param("record") AdcAssetCheckQueue record, @Param("example") AdcAssetCheckQueueExample example);

    int updateByExample(@Param("record") AdcAssetCheckQueue record, @Param("example") AdcAssetCheckQueueExample example);

    int updateByPrimaryKeySelective(AdcAssetCheckQueue record);

    int updateByPrimaryKeyWithBLOBs(AdcAssetCheckQueue record);

    int updateByPrimaryKey(AdcAssetCheckQueue record);
}