package com.hutc.app;

import com.hutc.app.entity.Hotel;
import com.hutc.app.entity.HotelRoom;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(AppConfig.class);

		Hotel hotel=context.getBean(Hotel.class);
		System.out.println(hotel.toString());

		HotelRoom hotelRoom=context.getBean(HotelRoom.class);
		System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry手动注册："+hotelRoom.toString());



	}

}
