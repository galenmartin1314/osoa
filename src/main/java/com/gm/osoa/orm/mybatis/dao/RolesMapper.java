package com.gm.osoa.orm.mybatis.dao;

import com.gm.osoa.orm.mybatis.model.Roles;
import com.gm.osoa.orm.mybatis.model.RolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesMapper extends BaseMapper<Roles, RolesExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    int countByExample(RolesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    int deleteByExample(RolesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    int deleteByPrimaryKey(String roleid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    int insert(Roles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    int insertSelective(Roles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    List<Roles> selectByExample(RolesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    Roles selectByPrimaryKey(String roleid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    int updateByExampleSelective(@Param("record") Roles record, @Param("example") RolesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    int updateByExample(@Param("record") Roles record, @Param("example") RolesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    int updateByPrimaryKeySelective(Roles record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table roles
     *
     * @mbggenerated Sun Sep 29 10:48:09 CST 2013
     */
    int updateByPrimaryKey(Roles record);
}