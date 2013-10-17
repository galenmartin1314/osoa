package com.gm.osoa.orm.mybatis.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gm.osoa.orm.mybatis.dao.BaseMapper;
import com.gm.osoa.orm.mybatis.dao.DeptMapper;
import com.gm.osoa.orm.mybatis.model.Dept;
import com.gm.osoa.orm.mybatis.model.DeptExample;
import com.gm.osoa.orm.mybatis.service.BaseServiceImpl;
@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept, DeptExample> {
	@Inject
	private DeptMapper deptDAO;
	
	@Override
	protected BaseMapper<Dept, DeptExample> getDAO() {
		// TODO Auto-generated method stub
		return deptDAO;
	}

}
