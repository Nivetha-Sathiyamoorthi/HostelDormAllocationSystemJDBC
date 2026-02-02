package com.hostel.bean;

import java.util.Date;

public class Allocation {
	private int allocationID;
	private String roomID;
	private String studentID;
	private String studentName;
	private Date allocateDate;
	private Date vacateDate;
	public int getAllocationID() {
		return allocationID;
	}
	public void setAllocationID(int allocationID) {
		this.allocationID = allocationID;
	}
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Date getAllocateDate() {
		return allocateDate;
	}
	public void setAllocateDate(Date allocateDate) {
		this.allocateDate = allocateDate;
	}
	public Date getVacateDate() {
		return vacateDate;
	}
	public void setVacateDate(Date vacateDate) {
		this.vacateDate = vacateDate;
	}
	
	
	
	
	

}
