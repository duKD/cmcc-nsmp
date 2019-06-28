package com.ultrapower.dao;

import com.ultrapower.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AmBsGroupMapper {
    int countByExample(AmBsGroupExample example);

    int deleteByExample(AmBsGroupExample example);

    int deleteByPrimaryKey(String pkBsGroup);

    int insert(AmBsGroup record);

    int insertSelective(AmBsGroup record);

    List<AmBsGroup> selectByExample(AmBsGroupExample example);

    AmBsGroup selectByPrimaryKey(String pkBsGroup);

    int updateByExampleSelective(@Param("record") AmBsGroup record, @Param("example") AmBsGroupExample example);

    int updateByExample(@Param("record") AmBsGroup record, @Param("example") AmBsGroupExample example);

    int updateByPrimaryKeySelective(AmBsGroup record);

    int updateByPrimaryKey(AmBsGroup record);

    List<AmBsDTO> sortAllAmBs();

    List<BsResultDTO> showConnectProv(String id);

    List<BsGroupConnectAsset> showConnectAsset(AssetQueryVO assetQueryVO);
}