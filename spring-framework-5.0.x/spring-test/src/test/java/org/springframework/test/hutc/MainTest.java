package org.springframework.test.hutc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	@Test
	public  void test01(){
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(HutcConfig.class);

		Hotel hotel =context.getBean(Hotel.class);

		System.out.println("spring ="+hotel.getHotelName() +"  "+hotel.getRoom().getRoomName());

	}


}
