package com.gm.osoa.action.base.settings;

import java.util.List;

import javax.inject.Inject;

import com.gm.osoa.action.base.BaseAction;
import com.gm.osoa.orm.mybatis.model.Privilege;
import com.gm.osoa.orm.mybatis.service.impl.PrivilegeServiceImpl;
public class PrivilegeEntity extends BaseAction {
	@Inject
	protected PrivilegeServiceImpl privilegeService;
	protected List<Privilege> rows;
	protected Privilege record;
	public List<Privilege> getRows() {
		return rows;
	}
	public void setRows(List<Privilege> rows) {
		this.rows = rows;
	}
	public Privilege getRecord() {
		return record;
	}
	public void setRecord(Privilege record) {
		this.record = record;
	}
}
