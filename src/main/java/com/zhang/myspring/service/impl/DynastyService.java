package com.zhang.myspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhang.myspring.bean.DynastyBean;
import com.zhang.myspring.bean.ResultBean;
import com.zhang.myspring.dao.IDynastyDao;
import com.zhang.myspring.service.IDynastyService;

@Service
public class DynastyService implements IDynastyService {
	
	@Autowired
	private IDynastyDao dynastyDao;

	@Override
	public List<DynastyBean> getDynastyList() throws Exception {
		return dynastyDao.find();
	}

}
