package com.gm.osoa.action.base;

import javax.inject.Inject;

import com.gm.osoa.orm.mybatis.model.Emp;
import com.gm.osoa.orm.mybatis.service.impl.EmpServiceImpl;


public class UserLoginEntity extends BaseAction {
	@Inject
	protected EmpServiceImpl empService;
	protected Emp emp;
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
}
