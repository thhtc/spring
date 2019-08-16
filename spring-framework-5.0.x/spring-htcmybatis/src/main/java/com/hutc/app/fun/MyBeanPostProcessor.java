package com.hutc.app.fun;

import com.hutc.app.entity.Hotel;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("hotel")){
			Hotel hotel=(Hotel)bean;
			hotel.setHotelId(9999);

		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("hotel")){
			Hotel hotel=(Hotel)bean;
			hotel.setHotelName(hotel.getHotelName()+" shanghai");

		}
		return bean;
	}
}
