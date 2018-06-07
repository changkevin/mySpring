package com.zhang.myspring.dao;

import java.util.List;

import com.zhang.myspring.model.SysRole;


public interface ISysRoleDao {
	public List<SysRole> find() throws Exception;
}
