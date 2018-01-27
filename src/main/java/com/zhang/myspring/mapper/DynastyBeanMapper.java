package com.zhang.myspring.mapper;

import org.springframework.jdbc.core.RowMapper;

import com.zhang.myspring.bean.DynastyBean;
import com.zhang.myspring.util.StrUtil;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DynastyBeanMapper implements RowMapper<DynastyBean> {

    @Override
    public  DynastyBean mapRow(ResultSet rs, int rowNum) throws SQLException {
    	DynastyBean bean = new  DynastyBean();
        bean.setId(StrUtil.parseO2Int(rs.getInt("id")));
        bean.setName(rs.getString("name"));
        bean.setBeginYear(StrUtil.parseO2Int(rs.getInt("begin_year")));
        bean.setEndYear(StrUtil.parseO2Int(rs.getInt("end_year")));
        bean.setIsAssured(StrUtil.parseO2Int(rs.getInt("is_assured")));
        bean.setCaptitalId(StrUtil.parseO2Int(rs.getInt("captital_id")));       
        bean.setEmperorId(StrUtil.parseO2Int(rs.getInt("emperor_id")));
        bean.setParentId(StrUtil.parseO2Int(rs.getInt("parent_id")));
        bean.setLevel(StrUtil.parseO2Int(rs.getInt("level")));
        
        return bean;
    }
}
