package com.xl.springbootxl.mapper;


import com.xl.springbootxl.pojo.TUsrInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户表(SmgTUsrInf)表数据库访问层
 *
 * @author xl
 * @since 2020-12-16 13:11:05
 */
@Mapper
public interface TUsrInfMapper {

    /**
     * 通过ID查询单条数据，登录的时候需要用到该接口
     */
    TUsrInf queryById(String usrId);

    /**
     *  通过任何用户的任何数据都可以查询
     * @param map
     * @return
     */
    List<TUsrInf> querySmgTUsrInf(Map map);






}
