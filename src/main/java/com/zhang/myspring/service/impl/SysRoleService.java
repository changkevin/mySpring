package com.zhang.myspring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhang.myspring.model.SysRole;
import com.zhang.myspring.dao.ISysRoleDao;
import com.zhang.myspring.service.ISysRoleService;

@Service
public class SysRoleService implements ISysRoleService{

	@Autowired
	private ISysRoleDao sysRoleDao;
	
	@Override
	public List<SysRole> getRoleList() throws Exception {
		return sysRoleDao.find();
	}

}
