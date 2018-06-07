package com.zhang.myspring.model;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 * 运行之前请注释掉spring-servlet.xml里的<context:component-scan base-package="com.zhang.myspring.*" />
 * @author zhangchuankai
 *
 */
public class _JFinalModelGenerator {		
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/*.xml");
		DataSource dataSource = (DataSource)ac.getBean("myspringDataSource");
		
		// base model 所使用的包名
		String baseModelPackageName = "com.zhang.myspring.model.base";
		// base model 文件保存路径
		String baseModelOutputDir = PathKit.getWebRootPath() + "/src/main/java/com/zhang/myspring/model/base";
		
		// model 所使用的包名 (MappingKit 默认使用的包名)
		String modelPackageName = "com.zhang.myspring.model";
		// model 文件保存路径 (MappingKit 与 DataDictionary 文件默认保存路径)
		String modelOutputDir = baseModelOutputDir + "/..";
		
		// 创建生成器
		Generator generator = new Generator(dataSource, baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
		// 设置是否生成链式 setter 方法
		generator.setGenerateChainSetter(false);
		// 添加不需要生成的表名
		generator.addExcludedTable("adv");
		// 设置是否在 Model 中生成 dao 对象
		generator.setGenerateDaoInModel(true);
		// 设置是否生成链式 setter 方法
		generator.setGenerateChainSetter(true);
		// 设置是否生成字典文件
		generator.setGenerateDataDictionary(false);
		// 设置需要被移除的表名前缀用于生成modelName。例如表名 "osc_user"，移除前缀 "osc_"后生成的model名为 "User"而非 OscUser
		generator.setRemovedTableNamePrefixes("t_");
		// 生成
		generator.generate();
	}
}




