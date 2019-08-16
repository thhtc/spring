package org.springframework.test.hutc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("org.springframework.test.hutc.bean")
public class HutcConfig {

	@Bean
	public Hotel getHotel(){
		return  new Hotel();
	}
}
