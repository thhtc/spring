package com.hutc.app.fun;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyInitializingBean implements InitializingBean, DisposableBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("项目启动");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("项目关闭");
	}
}
