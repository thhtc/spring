package org.springframework.test.hutc.bean;

import org.springframework.stereotype.Component;

@Component
public class Room {

	private String roomName="大床";

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
}
