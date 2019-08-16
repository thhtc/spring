package com.hutc.app.entity;

public class HotelRoom {
	private int hotelId=1;
	private String des="我是通过MyBeanDefinitionRegistryPostProcessor类实现BeanDefinitionRegistryPostProcessor接口注册的";

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "HotelRoom{" +
				"hotelId=" + hotelId +
				", des='" + des + '\'' +
				'}';
	}
}
