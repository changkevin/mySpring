package com.zhang.myspring.bean;

public class DynastyBean extends BaseBean {
	private int id; //主键
	private String name; //朝代名称
	private int beginYear; //创建年
	private int endYear; //灭亡年
	private int isAssured; //纪年是否确定，0：否，1：是
	private int captitalId; // 首都id
	private int emperorId; //创建者id
	private int parentId; //所属朝代id
	private int level; //朝代划分级别
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBeginYear() {
		return beginYear;
	}
	public void setBeginYear(int beginYear) {
		this.beginYear = beginYear;
	}
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	public int getIsAssured() {
		return isAssured;
	}
	public void setIsAssured(int isAssured) {
		this.isAssured = isAssured;
	}
	public int getCaptitalId() {
		return captitalId;
	}
	public void setCaptitalId(int captitalId) {
		this.captitalId = captitalId;
	}
	public int getEmperorId() {
		return emperorId;
	}
	public void setEmperorId(int emperorId) {
		this.emperorId = emperorId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "DynastyBean [id=" + id + ", name=" + name + ", beginYear=" + beginYear + ", endYear=" + endYear
				+ ", isAssured=" + isAssured + ", captitalId=" + captitalId + ", emperorId=" + emperorId + ", parentId="
				+ parentId + ", level=" + level + "]";
	}
		
}
