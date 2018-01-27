package com.zhang.myspring.dao;

import java.util.List;
import com.zhang.myspring.bean.DynastyBean;


public interface IDynastyDao {
	public List<DynastyBean> find() throws Exception;
}