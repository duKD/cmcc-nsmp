package com.ultrapower.dao;

import com.ultrapower.pojo.AdcAssetProblemDetail;
import com.ultrapower.pojo.AdcAssetProblemDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdcAssetProblemDetailMapper {
    int countByExample(AdcAssetProblemDetailExample example);

    int deleteByExample(AdcAssetProblemDetailExample example);

    int deleteByPrimaryKey(String pkAssetProblemDetail);

    int insert(AdcAssetProblemDetail record);

    int insertSelective(AdcAssetProblemDetail record);

    List<AdcAssetProblemDetail> selectByExample(AdcAssetProblemDetailExample example);

    AdcAssetProblemDetail selectByPrimaryKey(String pkAssetProblemDetail);

    int updateByExampleSelective(@Param("record") AdcAssetProblemDetail record, @Param("example") AdcAssetProblemDetailExample example);

    int updateByExample(@Param("record") AdcAssetProblemDetail record, @Param("example") AdcAssetProblemDetailExample example);

    int updateByPrimaryKeySelective(AdcAssetProblemDetail record);

    int updateByPrimaryKey(AdcAssetProblemDetail record);
}