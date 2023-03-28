package com.xl.springbootxl.mapper;

import com.xl.springbootxl.pojo.TRlInf;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TRlInfMapper {
    int insert(TRlInf record);

    int insertSelective(TRlInf record);

    TRlInf queryById(String rlId);


}