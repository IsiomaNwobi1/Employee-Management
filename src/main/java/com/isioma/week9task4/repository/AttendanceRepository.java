package com.isioma.week9task4.repository;

import com.isioma.week9task4.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>  {

}
