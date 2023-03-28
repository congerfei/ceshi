package com.xl.springbootxl.mapper;

import com.xl.springbootxl.pojo.TUsrRlRelInf;

import java.util.List;

public interface TUsrRlRelInfMapper {
    int insert(TUsrRlRelInf record);

    int insertSelective(TUsrRlRelInf record);

    /**
     * 根据用户 Id 查询用户角色
     *
     * @param usrId
     * @return
     */
    List<TUsrRlRelInf> selectRoleByUserId(String usrId);
}