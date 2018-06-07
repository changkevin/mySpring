package com.zhang.myspring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhang.myspring.bean.ParamBean;


@Controller
@RequestMapping(value = "/hello")
public class HelloController extends BaseController{
	public static final Log logger = LogFactory.getLog(HelloController.class);
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response) {
		String result = "hello springmvc";
		try {
			return result;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = "/paramtest")
	@ResponseBody
	public String paramTest(String param, HttpServletRequest request, HttpServletResponse response) {
		String result = "hello springmvc";
		try {
			//for(ParamBean item : param) {
			//	System.out.println(item.toString());
			//}
			System.out.println(param);
			return result;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
