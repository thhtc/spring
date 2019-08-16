package com.hutc.app;

import com.hutc.app.dao.TestDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(AppConfig.class);

		TestDao test =context.getBean(TestDao.class);
		test.query();
	}
}
