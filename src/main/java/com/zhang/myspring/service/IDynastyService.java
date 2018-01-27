package com.zhang.myspring.service;

import java.util.List;
import com.zhang.myspring.bean.DynastyBean;


public interface IDynastyService {
	public List<DynastyBean> getDynastyList() throws Exception;
}
