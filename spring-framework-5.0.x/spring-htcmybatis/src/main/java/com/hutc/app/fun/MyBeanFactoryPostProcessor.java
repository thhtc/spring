package com.hutc.app.fun;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//System.out.println("调用了自定义的BeanFactoryPostProcessor " + beanFactory);
		Iterator it = beanFactory.getBeanNamesIterator();
		String[] names = beanFactory.getBeanDefinitionNames();
		// 获取了所有的bean名称列表
		for(int i=0; i<names.length; i++){
			String name = names[i];
			BeanDefinition bd = beanFactory.getBeanDefinition(name);
			MutablePropertyValues pv =  bd.getPropertyValues();
			//System.out.println(name + " bean properties: " + bd.getPropertyValues().toString());
			if(name.equals("hotel")){
				pv.addPropertyValue("desc", "本字段值已经被 bean factory post processor 修改了(BeanFactoryPostProcessor接口)");
				bd.setScope(BeanDefinition.SCOPE_SINGLETON);
			}
		}
	}
}
