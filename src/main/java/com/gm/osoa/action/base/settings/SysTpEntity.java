package com.gm.osoa.action.base.settings;

import java.util.List;

import javax.inject.Inject;

import com.gm.osoa.action.base.BaseAction;
import com.gm.osoa.orm.mybatis.model.SysTp;
import com.gm.osoa.orm.mybatis.service.impl.SysTpServiceImpl;

public class SysTpEntity extends BaseAction {
	@Inject
	protected SysTpServiceImpl sysTpService;
	protected List<SysTp> rows;
	protected SysTp record;
	public List<SysTp> getRows() {
		return rows;
	}
	public void setRows(List<SysTp> rows) {
		this.rows = rows;
	}
	public SysTp getRecord() {
		return record;
	}
	public void setRecord(SysTp record) {
		this.record = record;
	}
}
