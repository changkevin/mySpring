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

import com.zhang.myspring.model.SysRole;
import com.zhang.myspring.bean.ResultBean;
import com.zhang.myspring.service.ISysRoleService;

@Controller
@RequestMapping(value = "/role")
public class SysRoleController extends BaseController{
public static final Log logger = LogFactory.getLog(SysRoleController.class);
	
	@Autowired
	private ISysRoleService sysRoleService;
	
	@RequestMapping(value = "/getList")
	@ResponseBody
	public ResultBean getRoleList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<SysRole> result = sysRoleService.getRoleList();
			return response().ok(result);
		} catch (Exception e) {
			return response().error(e.getMessage());
		}
	}
}
