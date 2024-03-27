package com.isioma.week9task4.service.impl;

import com.isioma.week9task4.entity.Leave;
import com.isioma.week9task4.repository.LeaveRepository;
import com.isioma.week9task4.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public LeaveServiceImpl(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }
    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave saveLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    @Override
    public Leave getLeaveById(Long id) {
        return leaveRepository.findById(id).get();
    }

    @Override
    public Leave updateLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    @Override
    public void deleteLeaveById(Long id) {
        leaveRepository.deleteById(id);
    }
}
