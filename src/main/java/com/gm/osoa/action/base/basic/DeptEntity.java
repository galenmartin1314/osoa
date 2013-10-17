package com.gm.osoa.action.base.basic;

import java.util.List;

import javax.inject.Inject;

import com.gm.osoa.action.base.BaseAction;
import com.gm.osoa.orm.mybatis.model.Dept;
import com.gm.osoa.orm.mybatis.service.impl.DeptServiceImpl;

public class DeptEntity extends BaseAction {
	@Inject
	protected DeptServiceImpl deptService;
	protected List<Dept> rows;
	protected Dept record;
//	protected List<String> pid;
	protected boolean sign = false;
	public List<Dept> getRows() {
		return rows;
	}
	public void setRows(List<Dept> rows) {
		this.rows = rows;
	}
	public Dept getRecord() {
		return record;
	}
	public void setRecord(Dept record) {
		this.record = record;
	}
//	public List<String> getPid() {
//		return pid;
//	}
//	public void setPid(List<String> pid) {
//		this.pid = pid;
//	}
	public boolean isSign() {
		return sign;
	}
	public void setSign(boolean sign) {
		this.sign = sign;
	}
}
