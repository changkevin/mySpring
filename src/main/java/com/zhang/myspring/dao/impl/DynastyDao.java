package com.zhang.myspring.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.zhang.myspring.bean.DynastyBean;
import com.zhang.myspring.dao.IDynastyDao;
import com.zhang.myspring.mapper.DynastyBeanMapper;

@Repository
public class DynastyDao extends BaseDao implements IDynastyDao{

	@Override
	public List<DynastyBean> find() throws Exception {
		List<DynastyBean> resultList=new ArrayList<DynastyBean>();
		String sql = "select * from t_ta_dynasty ";
		resultList = jdbcTemplate.query(sql, new DynastyBeanMapper());

		return resultList;
	}

}
