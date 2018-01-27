package com.zhang.myspring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhang.myspring.bean.DynastyBean;
import com.zhang.myspring.bean.ResultBean;
import com.zhang.myspring.service.IDynastyService;

@Controller
@RequestMapping(value = "/dy")
public class DynastyController extends BaseController{
	public static final Log logger = LogFactory.getLog(DynastyController.class);
	
	@Autowired
	private IDynastyService dynastyService;
	
	@RequestMapping(value = "/getList")
	@ResponseBody
	public ResultBean getDynastyList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<DynastyBean> result = dynastyService.getDynastyList();
			return response().ok(result);
		} catch (Exception e) {
			return response().error(e.getMessage());
		}
	}
}
