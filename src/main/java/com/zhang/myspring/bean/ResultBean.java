package com.zhang.myspring.bean;

import com.zhang.myspring.util.StrUtil;

public class ResultBean {
	private int status;
	private Object result;
	private String msg;
	private String queryInfo;
	private Object meta;
	private Object param;

	public ResultBean(int status, String msg) {
        super();
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getQueryInfo() {
		return queryInfo;
	}

	public void setQueryInfo(String queryInfo) {
		this.queryInfo = queryInfo;
	}

	public ResultBean() {
		queryInfo = StrUtil.getUUID();
	}

	public ResultBean(Object meta) {
		this.meta = meta;
		queryInfo = StrUtil.getUUID();
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	public Object getMeta() {
		return meta;
	}

	public void setMeta(Object meta) {
		this.meta = meta;
	}

	public ResultBean ok() {
		this.status = 1;
		this.msg = "success";
		return this;
	}

	public ResultBean ok(Object result) {
		this.status = 1;
		this.msg = "success";
		this.result = result;
		return this;
	}

	public ResultBean error() {
		this.status = 0;
		this.msg = "error";
		return this;
	}

	public ResultBean error(String msg) {
		this.status = 0;
		this.msg = msg;
		return this;
	}
}
