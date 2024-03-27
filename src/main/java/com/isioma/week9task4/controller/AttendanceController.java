package com.isioma.week9task4.controller;

import com.isioma.week9task4.entity.Attendance;
import com.isioma.week9task4.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/attendances")
    public String listAllAttendances(Model model) {
        model.addAttribute("attendances", attendanceService.getAllAttendances());

        return "attendances";
    }

    @GetMapping("attendances/new")
    public String createAttendanceForm(Model model) {
        Attendance attendance = new Attendance();
        model.addAttribute("attendance", attendance);

        return "add_attendance";
    }

    @PostMapping("/attendances")
    public String saveAttendance(@ModelAttribute("attendance") Attendance attendance) {
        attendanceService.saveAttendance(attendance);

        return "redirect:/attendances";
    }

    @GetMapping("/attendances/edit/{id}")
    public String editAttendanceForm(@PathVariable Long id, Model model) {
        model.addAttribute("attendance", attendanceService.getAttendanceById(id));

        return "edit_attendance";
    }

    @PostMapping("/attendances/{id}")
    public String updateAttendance(@PathVariable Long id,
                                 @ModelAttribute("attendance") Attendance attendance,
                                 Model model) {

        Attendance existingAttendance = attendanceService.getAttendanceById(id);
        existingAttendance.setEmployeeName(attendance.getEmployeeName());
        existingAttendance.setEmployeeName(attendance.getEmail());
        existingAttendance.setDate(attendance.getDate());
        existingAttendance.setClockInTime(attendance.getClockInTime());
        existingAttendance.setClockOutTime(attendance.getClockOutTime());

        attendanceService.updateAttendance(existingAttendance);

        return "redirect:/attendances";

    }

    @GetMapping("/attendances/{id}")
    public String deleteAttendanceById(@PathVariable Long id) {
        attendanceService.deleteAttendanceById(id);

        return "redirect:/attendances";
    }
}

