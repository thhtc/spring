package com.hutc.app.entity;

public class Room {
	private int roomId=2;
	private String roomName="总统豪华大床房";

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return "Room{" +
				"roomId=" + roomId +
				", roomName='" + roomName + '\'' +
				'}';
	}
}
