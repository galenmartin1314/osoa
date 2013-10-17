package com.gm.osoa.orm.mybatis.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gm.osoa.orm.mybatis.dao.BaseMapper;
import com.gm.osoa.orm.mybatis.dao.RolesMapper;
import com.gm.osoa.orm.mybatis.model.Roles;
import com.gm.osoa.orm.mybatis.model.RolesExample;
import com.gm.osoa.orm.mybatis.service.BaseServiceImpl;

@Service
public class RolesServiceImpl extends BaseServiceImpl<Roles, RolesExample> {
	@Inject
	protected RolesMapper rolesDAO;
	
	@Override
	protected BaseMapper<Roles, RolesExample> getDAO() {
		// TODO Auto-generated method stub
		return rolesDAO;
	}

}
