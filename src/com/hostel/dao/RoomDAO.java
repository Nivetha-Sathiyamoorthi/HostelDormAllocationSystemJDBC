package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hostel.bean.Room;
import com.hostel.util.DBUtil;

public class RoomDAO {
	public Room findRoom(String roomID) {
		try {
		Connection con = DBUtil.getDBConnection();
		PreparedStatement ps = con.prepareStatement(
		"SELECT * FROM ROOM_TBL WHERE ROOM_ID = ?"
		);
		ps.setString(1, roomID);
		ResultSet rs = ps.executeQuery();
        if (rs.next()) {
		Room r = new Room();
		r.setRoomID(rs.getString(1));
		r.setRoomType(rs.getString(2));
		r.setTotalUnits(rs.getInt(3));
		r.setOccupiedUnits(rs.getInt(4));
		r.setCapacity(rs.getInt(5));
		return r;
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
		}
	public List<Room> viewAllRooms() {
		List<Room> list = new ArrayList<>();
		try {
		Connection con = DBUtil.getDBConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM ROOM_TBL");
        while (rs.next()) {
		Room r = new Room();
		r.setRoomID(rs.getString(1));
		r.setRoomType(rs.getString(2));
		r.setTotalUnits(rs.getInt(3));
		r.setOccupiedUnits(rs.getInt(4));
		r.setCapacity(rs.getInt(5));
		list.add(r);
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return list;
		}
	public boolean insertRoom(Room room) {
		try {
		Connection con = DBUtil.getDBConnection();
		PreparedStatement ps = con.prepareStatement(
		"INSERT INTO ROOM_TBL VALUES (?,?,?,?,?)"
		);
		ps.setString(1, room.getRoomID());
		ps.setString(2, room.getRoomType());
		ps.setInt(3, room.getTotalUnits());
		ps.setInt(4, room.getOccupiedUnits());
		ps.setInt(5, room.getCapacity());
		return ps.executeUpdate() > 0;
		} catch (Exception e) {
			 e.printStackTrace();
		return false;
		}
		}
	public boolean updateOccupiedUnits(String roomID, int count) {
		try {
		Connection con = DBUtil.getDBConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE ROOM_TBL SET OCCUPIED_UNITS=? WHERE ROOM_ID=?");
		ps.setInt(1, count);
		ps.setString(2, roomID);
		return ps.executeUpdate() > 0;
		} catch (Exception e) {
			 e.printStackTrace();
		return false;
		}
		}
public boolean deleteRoom(String roomID) {
		try {
		Connection con = DBUtil.getDBConnection();
		PreparedStatement ps = con.prepareStatement(
		"DELETE FROM ROOM_TBL WHERE ROOM_ID=?"
		);
		ps.setString(1, roomID);
		return ps.executeUpdate() > 0;
		} catch (Exception e) {
			 e.printStackTrace();
		return false;
		}
		}

}
