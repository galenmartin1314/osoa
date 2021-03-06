package com.gm.osoa.orm.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gm.osoa.orm.mybatis.model.SysTp;
import com.gm.osoa.orm.mybatis.model.SysTpExample;

public interface SysTpMapper extends BaseMapper<SysTp, SysTpExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int countByExample(SysTpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int deleteByExample(SysTpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int deleteByPrimaryKey(String tpId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int insert(SysTp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int insertSelective(SysTp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    List<SysTp> selectByExample(SysTpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    SysTp selectByPrimaryKey(String tpId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByExampleSelective(@Param("record") SysTp record, @Param("example") SysTpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByExample(@Param("record") SysTp record, @Param("example") SysTpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByPrimaryKeySelective(SysTp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByPrimaryKey(SysTp record);
}