package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hostel.bean.Allocation;
import com.hostel.util.DBUtil;

public class AllocationDAO {
public int generateAllocationID() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
         try {
            con = DBUtil.getDBConnection();
            ps = con.prepareStatement(
                    "SELECT ALLOCATION_SEQ.NEXTVAL FROM DUAL");
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return 0;
    }
public boolean recordAllocation(Allocation a) {
        Connection con = null;
        PreparedStatement ps = null;
 try {
            con = DBUtil.getDBConnection();
            ps = con.prepareStatement(
                    "INSERT INTO ALLOCATION_TBL VALUES (?,?,?,?,?,NULL)");
            ps.setInt(1, a.getAllocationID());
            ps.setString(2, a.getRoomID());
            ps.setString(3, a.getStudentID());
            ps.setString(4, a.getStudentName());
            ps.setDate(5,new java.sql.Date(a.getAllocateDate().getTime()));
            return ps.executeUpdate() > 0;
            } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return false;
    }
public boolean removeAllocation(int allocationID) {
        Connection con = null;
        PreparedStatement ps = null;
         try {
            con = DBUtil.getDBConnection();
            ps = con.prepareStatement( "DELETE FROM ALLOCATION_TBL WHERE ALLOCATION_ID=?");
              ps.setInt(1, allocationID);
            return ps.executeUpdate() > 0;
             } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return false;
    }
}
