package com.hutc.app.entity;

import org.springframework.stereotype.Component;

@Component
public class Hotel {
	private int hotelId=1;
	private String hotelName="上海大酒店";
	private String desc="我是空的";

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Hotel{" +
				"hotelId=" + hotelId +
				", hotelName='" + hotelName + '\'' +
				", desc='" + desc + '\'' +
				'}';
	}
}
