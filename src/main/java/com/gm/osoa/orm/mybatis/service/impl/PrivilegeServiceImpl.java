package com.gm.osoa.orm.mybatis.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gm.osoa.orm.mybatis.dao.BaseMapper;
import com.gm.osoa.orm.mybatis.dao.PrivilegeMapper;
import com.gm.osoa.orm.mybatis.model.Privilege;
import com.gm.osoa.orm.mybatis.model.PrivilegeExample;
import com.gm.osoa.orm.mybatis.service.BaseServiceImpl;
@Service
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege, PrivilegeExample> {
	@Inject
	private PrivilegeMapper privilegeDAO;

	@Override
	protected BaseMapper<Privilege, PrivilegeExample> getDAO() {
		// TODO Auto-generated method stub
		return privilegeDAO;
	}

}
