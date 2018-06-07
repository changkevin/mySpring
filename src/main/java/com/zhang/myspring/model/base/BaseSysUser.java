package com.zhang.myspring.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseSysUser<M extends BaseSysUser<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Long id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	public M setUserId(java.lang.String userId) {
		set("user_id", userId);
		return (M)this;
	}
	
	public java.lang.String getUserId() {
		return getStr("user_id");
	}

	public M setUsername(java.lang.String username) {
		set("username", username);
		return (M)this;
	}
	
	public java.lang.String getUsername() {
		return getStr("username");
	}

	public M setPassword(java.lang.String password) {
		set("password", password);
		return (M)this;
	}
	
	public java.lang.String getPassword() {
		return getStr("password");
	}

	public M setSex(java.lang.Integer sex) {
		set("sex", sex);
		return (M)this;
	}
	
	public java.lang.Integer getSex() {
		return getInt("sex");
	}

	public M setNickname(java.lang.String nickname) {
		set("nickname", nickname);
		return (M)this;
	}
	
	public java.lang.String getNickname() {
		return getStr("nickname");
	}

	public M setRegisterType(java.lang.Integer registerType) {
		set("register_type", registerType);
		return (M)this;
	}
	
	public java.lang.Integer getRegisterType() {
		return getInt("register_type");
	}

	public M setEmail(java.lang.String email) {
		set("email", email);
		return (M)this;
	}
	
	public java.lang.String getEmail() {
		return getStr("email");
	}

	public M setPhone(java.lang.String phone) {
		set("phone", phone);
		return (M)this;
	}
	
	public java.lang.String getPhone() {
		return getStr("phone");
	}

	public M setAddress(java.lang.String address) {
		set("address", address);
		return (M)this;
	}
	
	public java.lang.String getAddress() {
		return getStr("address");
	}

	public M setIconUrl(java.lang.String iconUrl) {
		set("icon_url", iconUrl);
		return (M)this;
	}
	
	public java.lang.String getIconUrl() {
		return getStr("icon_url");
	}

	public M setProfile(java.lang.String profile) {
		set("profile", profile);
		return (M)this;
	}
	
	public java.lang.String getProfile() {
		return getStr("profile");
	}

	public M setState(java.lang.Integer state) {
		set("state", state);
		return (M)this;
	}
	
	public java.lang.Integer getState() {
		return getInt("state");
	}

	public M setLoginCount(java.lang.Integer loginCount) {
		set("login_count", loginCount);
		return (M)this;
	}
	
	public java.lang.Integer getLoginCount() {
		return getInt("login_count");
	}

	public M setLastLoginTime(java.util.Date lastLoginTime) {
		set("last_login_time", lastLoginTime);
		return (M)this;
	}
	
	public java.util.Date getLastLoginTime() {
		return get("last_login_time");
	}

	public M setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
		return (M)this;
	}
	
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public M setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
		return (M)this;
	}
	
	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

}
