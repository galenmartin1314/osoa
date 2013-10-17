package com.gm.osoa.orm.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gm.osoa.orm.mybatis.model.Dept;
import com.gm.osoa.orm.mybatis.model.DeptExample;

public interface DeptMapper extends BaseMapper<Dept, DeptExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int countByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int deleteByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int deleteByPrimaryKey(String deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int insert(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int insertSelective(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    List<Dept> selectByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    Dept selectByPrimaryKey(String deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByPrimaryKeySelective(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dept
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByPrimaryKey(Dept record);
}