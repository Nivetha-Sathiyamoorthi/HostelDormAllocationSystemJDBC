package com.hostel.service;

import java.util.Date;

import com.hostel.bean.Allocation;
import com.hostel.bean.Room;
import com.hostel.dao.AllocationDAO;
import com.hostel.dao.RoomDAO;
import com.hostel.util.NoVacancyException;
import com.hostel.util.ValidationException;

public class HostelService {

    RoomDAO roomDAO = new RoomDAO();
    AllocationDAO allocationDAO = new AllocationDAO();
  public boolean allocateStudent(String roomID,String studentID,String studentName)
            throws ValidationException, NoVacancyException {
 if (roomID == null || studentID == null || studentName == null)
            throw new ValidationException();
 Room room = roomDAO.findRoom(roomID);
        if (room == null)
            return false;
          if (room.getOccupiedUnits() >= room.getTotalUnits())
            throw new NoVacancyException();
         int newCount = room.getOccupiedUnits() + 1;
        roomDAO.updateOccupiedUnits(roomID, newCount);
          Allocation alloc = new Allocation();
        alloc.setAllocationID(allocationDAO.generateAllocationID());
        alloc.setRoomID(roomID);
        alloc.setStudentID(studentID);
        alloc.setStudentName(studentName);
        alloc.setAllocateDate(new Date());
         return allocationDAO.recordAllocation(alloc);
    }
    public boolean vacateStudent(int allocationID)
            throws ValidationException {
            if (allocationID <= 0)
            throw new ValidationException();
               return allocationDAO.removeAllocation(allocationID);
    }
}
