package com.xl.gen.service;

import com.xl.gen.entity.SmgTUsrInf;
import java.util.List;

/**
 * 用户表(SmgTUsrInf)表服务接口
 *
 * @author xl
 * @since 2020-12-16 13:11:05
 */
public interface SmgTUsrInfService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    SmgTUsrInf queryById( );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SmgTUsrInf> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param smgTUsrInf 实例对象
     * @return 实例对象
     */
    SmgTUsrInf insert(SmgTUsrInf smgTUsrInf);

    /**
     * 修改数据
     *
     * @param smgTUsrInf 实例对象
     * @return 实例对象
     */
    SmgTUsrInf update(SmgTUsrInf smgTUsrInf);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    boolean deleteById( );

}