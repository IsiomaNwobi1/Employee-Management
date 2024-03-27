package com.isioma.week9task4.controller;

import com.isioma.week9task4.entity.Leave;
import com.isioma.week9task4.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @GetMapping("/leaves")
    public String listAllLeaves(Model model) {
        model.addAttribute("leaves", leaveService.getAllLeaves());

        return "leaves";
    }

    @GetMapping("leaves/new")
    public String createLeaveForm(Model model) {
        Leave leave = new Leave();
        model.addAttribute("leave", leave);

        return "add_leave";
    }

    @PostMapping("/leaves")
    public String saveLeave (@ModelAttribute("leave") Leave leave) {
        leaveService.saveLeave(leave);

        return "redirect:/leaves";
    }

    @GetMapping("/leaves/edit/{id}")
    public String editLeaveForm(@PathVariable Long id, Model model) {
        model.addAttribute("leave", leaveService.getLeaveById(id));

        return "edit_leave";
    }

    @PostMapping("/leaves/{id}")
    public String updateLeave(@PathVariable Long id,
                                 @ModelAttribute("leave") Leave leave,
                                 Model model) {

        Leave existingLeave = leaveService.getLeaveById(id);
        existingLeave.setEmployeeName(leave.getEmployeeName());
        existingLeave.setEmail(leave.getEmail());
        existingLeave.setPhoneNumber(leave.getPhoneNumber());
        existingLeave.setLeaveStartDate(leave.getLeaveStartDate());
        existingLeave.setLeaveEndDate(leave.getLeaveEndDate());
        existingLeave.setLeaveType(leave.getLeaveType());
        existingLeave.setLeaveStatus(leave.getLeaveStatus());

        leaveService.updateLeave(existingLeave);

        return "redirect:/leaves";

    }

    @GetMapping("/leaves/{id}")
    public String deleteLeaveById(@PathVariable Long id) {
        leaveService.deleteLeaveById(id);

        return "redirect:/leaves";
    }
}
