package com.isioma.week9task4.service;

import com.isioma.week9task4.entity.Attendance;

import java.util.List;

public interface AttendanceService {

    List<Attendance> getAllAttendances();
    Attendance saveAttendance (Attendance attendance);

    Attendance getAttendanceById (Long id);

    Attendance updateAttendance (Attendance attendance);

    void deleteAttendanceById (Long id);

}
