package com.gm.osoa.orm.mybatis.model;

public class Dept {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dept.dept_id
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	private String deptId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dept.dept_no
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	private String deptNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dept.dept_name
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	private String deptName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dept.dept_tel
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	private String deptTel;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dept.dept_lnkman
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	private String deptLnkman;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dept.sup_id
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	private String supId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dept.dept_id
	 * @return  the value of dept.dept_id
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dept.dept_id
	 * @param deptId  the value for dept.dept_id
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId == null ? null : deptId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dept.dept_no
	 * @return  the value of dept.dept_no
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public String getDeptNo() {
		return deptNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dept.dept_no
	 * @param deptNo  the value for dept.dept_no
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo == null ? null : deptNo.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dept.dept_name
	 * @return  the value of dept.dept_name
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dept.dept_name
	 * @param deptName  the value for dept.dept_name
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName == null ? null : deptName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dept.dept_tel
	 * @return  the value of dept.dept_tel
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public String getDeptTel() {
		return deptTel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dept.dept_tel
	 * @param deptTel  the value for dept.dept_tel
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void setDeptTel(String deptTel) {
		this.deptTel = deptTel == null ? null : deptTel.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dept.dept_lnkman
	 * @return  the value of dept.dept_lnkman
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public String getDeptLnkman() {
		return deptLnkman;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dept.dept_lnkman
	 * @param deptLnkman  the value for dept.dept_lnkman
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void setDeptLnkman(String deptLnkman) {
		this.deptLnkman = deptLnkman == null ? null : deptLnkman.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dept.sup_id
	 * @return  the value of dept.sup_id
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public String getSupId() {
		return supId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dept.sup_id
	 * @param supId  the value for dept.sup_id
	 * @mbggenerated  Tue Sep 03 10:32:39 CST 2013
	 */
	public void setSupId(String supId) {
		this.supId = supId == null ? null : supId.trim();
	}
}