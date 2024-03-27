package com.isioma.week9task4.service;

import com.isioma.week9task4.entity.Leave;

import java.util.List;

public interface LeaveService {

    List<Leave> getAllLeaves();
    Leave saveLeave (Leave leave);

    Leave getLeaveById (Long id);

    Leave updateLeave (Leave leave);

    void deleteLeaveById (Long id);

}
