package com.gm.osoa.orm.mybatis.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gm.osoa.orm.mybatis.dao.BaseMapper;
import com.gm.osoa.orm.mybatis.dao.SysTpMapper;
import com.gm.osoa.orm.mybatis.model.SysTp;
import com.gm.osoa.orm.mybatis.model.SysTpExample;
import com.gm.osoa.orm.mybatis.service.BaseServiceImpl;
@Service
public class SysTpServiceImpl extends BaseServiceImpl<SysTp, SysTpExample> {
	@Inject
	private SysTpMapper sysTpDAO;
	
	@Override
	protected BaseMapper<SysTp, SysTpExample> getDAO() {
		// TODO Auto-generated method stub
		return sysTpDAO;
	}

}
