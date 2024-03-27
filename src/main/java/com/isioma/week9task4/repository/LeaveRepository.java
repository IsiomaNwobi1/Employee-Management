package com.isioma.week9task4.repository;

import com.isioma.week9task4.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}
