package com.zhang.myspring.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseTaEmperor<M extends BaseTaEmperor<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setName(java.lang.String name) {
		set("name", name);
		return (M)this;
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}

	public M setIsFounder(java.lang.Integer isFounder) {
		set("is_founder", isFounder);
		return (M)this;
	}
	
	public java.lang.Integer getIsFounder() {
		return getInt("is_founder");
	}

	public M setOrder(java.lang.Long order) {
		set("order", order);
		return (M)this;
	}
	
	public java.lang.Long getOrder() {
		return getLong("order");
	}

}
