package com.xl.springbootxl.mapper;


import com.xl.springbootxl.pojo.TMenuInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * 用户表(SmgTUsrInf)表数据库访问层
 *
 * @author xl
 * @since 2020-12-16 13:11:05
 */
@Mapper
public interface TMenuInfMapper {


    ArrayList<TMenuInf> queryMenuTree();

    int insert(TMenuInf record);

    int insertSelective(TMenuInf record);
}
