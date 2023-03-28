package com.xl.gen.mapper;

import com.xl.gen.entity.SmgTUsrInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户表(SmgTUsrInf)表数据库访问层
 *
 * @author xl
 * @since 2020-12-16 13:11:05
 */
@Mapper
public interface SmgTUsrInfMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    SmgTUsrInf queryById( );

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SmgTUsrInf> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param smgTUsrInf 实例对象
     * @return 对象列表
     */
    List<SmgTUsrInf> queryAll(SmgTUsrInf smgTUsrInf);

    /**
     * 新增数据
     *
     * @param smgTUsrInf 实例对象
     * @return 影响行数
     */
    int insert(SmgTUsrInf smgTUsrInf);

    /**
     * 修改数据
     *
     * @param smgTUsrInf 实例对象
     * @return 影响行数
     */
    int update(SmgTUsrInf smgTUsrInf);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 影响行数
     */
    int deleteById( );

}