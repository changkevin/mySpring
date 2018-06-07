package com.zhang.myspring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.zhang.myspring.model.SysRole;
import com.zhang.myspring.model._MappingKit;

@Component
public class ActiveRecordConfig {
	// 由于spring中已经注入了DruidDataSource这里直接拿
    @Autowired 
    private DataSource myspringDataSource;
     
    @Bean(initMethod="start", destroyMethod="stop")
    public ActiveRecordPlugin init() {
    		System.out.println("------ActiveRecordPlugin init");
        ActiveRecordPlugin arp = new ActiveRecordPlugin(myspringDataSource);
        //arp.addMapping("t_sys_role", SysRole.class);
        _MappingKit.mapping(arp);
        
        return arp;
    }
}
