package com.ultrapower.dao;

import com.ultrapower.pojo.AdcAssetProblem;
import com.ultrapower.pojo.AdcAssetProblemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdcAssetProblemMapper {
    int countByExample(AdcAssetProblemExample example);

    int deleteByExample(AdcAssetProblemExample example);

    int deleteByPrimaryKey(String pkAssetProblem);

    int insert(AdcAssetProblem record);

    int insertSelective(AdcAssetProblem record);

    List<AdcAssetProblem> selectByExample(AdcAssetProblemExample example);

    AdcAssetProblem selectByPrimaryKey(String pkAssetProblem);

    int updateByExampleSelective(@Param("record") AdcAssetProblem record, @Param("example") AdcAssetProblemExample example);

    int updateByExample(@Param("record") AdcAssetProblem record, @Param("example") AdcAssetProblemExample example);

    int updateByPrimaryKeySelective(AdcAssetProblem record);

    int updateByPrimaryKey(AdcAssetProblem record);
}