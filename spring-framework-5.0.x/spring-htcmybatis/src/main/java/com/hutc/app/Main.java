package com.hutc.app;

import com.hutc.app.dao.RoleMapper;
import com.hutc.app.dao.TestDao;
import com.hutc.app.dao.TestMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring mybatis
 * @MapperScan(通过MapperScannerRegistrar.class类来实现) 注解扫描配置的包路径下的所有接口，设置这些接口的FactoryBean 类为：org.mybatis.spring.mapper.MapperFactoryBean.class
 * 在org.mybatis.spring.mapper.ClassPathMapperScanner#processBeanDefinitions(java.util.Set) 里设置definition.setBeanClass(this.mapperFactoryBean.getClass());
 * 第一次通过spring获取Bean时通过MapperFactoryBean生成他的动态代理类
 * 在调用Bean的相关方法（查询，修改，新增，删除等DB操作）时会去找@Select配置的SQL 在通过JDBC对DB执行操作。
 * MapperScannerRegistrar类实现了 org.springframework.context.annotation.ImportBeanDefinitionRegistrar接口registerBeanDefinitions方法
 *
 * */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(AppConfig.class);
		//org.mybatis.spring.mapper.MapperFactoryBean.class
		/*RoleMapper test =context.getBean(RoleMapper.class);
		System.out.println(test.queryAll());*/
		TestMapper test =context.getBean(TestMapper.class);
		System.out.println(test.queryAll());
	}
}
