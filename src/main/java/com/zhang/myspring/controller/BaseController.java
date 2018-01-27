package com.zhang.myspring.controller;

import com.zhang.myspring.bean.ResultBean;

public abstract class BaseController {
	public ResultBean response() {
		return new ResultBean();
	}
}
