package com.cloudcode.push;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.cloudcode.framework.annotation.ModuleConfig;
import com.cloudcode.framework.bean.ProjectBeanNameGenerator;
import com.cloudcode.framework.dao.ModelObjectDao;
import com.cloudcode.framework.dao.impl.BaseDaoImpl;
import com.cloudcode.push.model.RemindInf;

@ModuleConfig(name = ProjectConfig.NAME, domainPackages = { "com.cloudcode.push.model" })
@ComponentScan(basePackages = { "com.cloudcode.push.*" }, nameGenerator = ProjectBeanNameGenerator.class)
@PropertySource(name = "cloudcode.evn", value = { "classpath:proj.properties" })
public class ProjectConfig {
	public static final String NAME = "push";
	public static final String PREFIX = NAME + ".";

	@Bean(name = PREFIX + "remindInfDao")
	public ModelObjectDao<RemindInf> generateRemindInfDao() {
		return new BaseDaoImpl<RemindInf>();
	}

}
