package com.gm.osoa.action.base.settings;

import java.util.List;

import javax.inject.Inject;

import com.gm.osoa.action.base.BaseAction;
import com.gm.osoa.orm.mybatis.model.Roles;
import com.gm.osoa.orm.mybatis.service.impl.RolesServiceImpl;

public class RolesEntity extends BaseAction {
	@Inject
	protected RolesServiceImpl rolesService;
	protected List<Roles> rows;
	protected Roles record;
	public List<Roles> getRows() {
		return rows;
	}
	public void setRows(List<Roles> rows) {
		this.rows = rows;
	}
	public Roles getRecord() {
		return record;
	}
	public void setRecord(Roles record) {
		this.record = record;
	}
}
