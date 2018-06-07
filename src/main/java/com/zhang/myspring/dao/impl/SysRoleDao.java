package com.zhang.myspring.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.zhang.myspring.model.SysRole;
import com.zhang.myspring.dao.ISysRoleDao;

@Repository
public class SysRoleDao extends BaseDao implements ISysRoleDao{

	@Override
	public List<SysRole> find() throws Exception {
		List<SysRole> resultList = new ArrayList<SysRole>();
		final String sql = " select * from t_sys_role ";
		resultList = SysRole.dao.find(sql);
		System.out.println("resultList：" + resultList.size());
//		for(SysRoleModel item : resultList) {
//			System.out.println("resultList：" + resultList.size());
//		}
		return resultList;
	}

}
