package com.isioma.week9task4.controller;

import com.isioma.week9task4.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/employee_login")
public class LoginController {
    private EmployeeService employeeService;
    @GetMapping
    public String showLoginPage(){
        return "employee_login";
    }
}
