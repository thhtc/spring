package com.hutc.app.fun;

import com.hutc.app.entity.HotelRoom;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
		//System.out.println("执行 MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry");
		//创建一个bean的定义类的对象，bean类型是HotelRoom
		RootBeanDefinition hotelRoomBean = new RootBeanDefinition(HotelRoom.class);
		//bean的定义注册到spring环境
		beanDefinitionRegistry.registerBeanDefinition("hotelRoom", hotelRoomBean);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//System.out.println("执行 MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory");
	}
}
