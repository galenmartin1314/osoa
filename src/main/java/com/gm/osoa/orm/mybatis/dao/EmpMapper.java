package com.gm.osoa.orm.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gm.osoa.orm.mybatis.model.Emp;
import com.gm.osoa.orm.mybatis.model.EmpExample;

public interface EmpMapper extends BaseMapper<Emp, EmpExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int countByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int deleteByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int deleteByPrimaryKey(String empId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int insert(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int insertSelective(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    List<Emp> selectByExample(EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    Emp selectByPrimaryKey(String empId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByPrimaryKeySelective(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Tue Sep 03 10:32:39 CST 2013
     */
    int updateByPrimaryKey(Emp record);
}