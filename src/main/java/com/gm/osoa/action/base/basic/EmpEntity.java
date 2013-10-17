package com.gm.osoa.action.base.basic;

import java.util.List;

import javax.inject.Inject;

import com.gm.osoa.action.base.BaseAction;
import com.gm.osoa.orm.mybatis.model.Dept;
import com.gm.osoa.orm.mybatis.model.Emp;
import com.gm.osoa.orm.mybatis.service.impl.DeptServiceImpl;
import com.gm.osoa.orm.mybatis.service.impl.EmpServiceImpl;

public class EmpEntity extends BaseAction {
	@Inject
	protected EmpServiceImpl empService;
	protected List<Emp> rows;
	protected Emp record;
	protected List<String> pid;
	protected boolean sign = false;
	protected String empPwd = "";
	@Inject
	protected DeptServiceImpl deptService;
	protected Dept dept;
	public List<Emp> getRows() {
		return rows;
	}
	public void setRows(List<Emp> rows) {
		this.rows = rows;
	}
	public Emp getRecord() {
		return record;
	}
	public void setRecord(Emp record) {
		this.record = record;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public List<String> getPid() {
		return pid;
	}
	public void setPid(List<String> pid) {
		this.pid = pid;
	}
	public boolean isSign() {
		return sign;
	}
	public void setSign(boolean sign) {
		this.sign = sign;
	}
	public String getEmpPwd() {
		return empPwd;
	}
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}
}
