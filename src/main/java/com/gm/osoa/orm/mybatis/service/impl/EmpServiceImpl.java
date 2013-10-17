package com.gm.osoa.orm.mybatis.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gm.osoa.orm.mybatis.dao.BaseMapper;
import com.gm.osoa.orm.mybatis.dao.EmpMapper;
import com.gm.osoa.orm.mybatis.model.Emp;
import com.gm.osoa.orm.mybatis.model.EmpExample;
import com.gm.osoa.orm.mybatis.service.BaseServiceImpl;
@Service
public class EmpServiceImpl extends BaseServiceImpl<Emp, EmpExample> {
	@Inject
	private EmpMapper empDAO;

	@Override
	protected BaseMapper<Emp, EmpExample> getDAO() {
		// TODO Auto-generated method stub
		return empDAO;
	}
}
