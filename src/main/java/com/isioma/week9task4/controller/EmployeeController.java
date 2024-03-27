package com.isioma.week9task4.controller;

import com.isioma.week9task4.entity.Employee;
import com.isioma.week9task4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String listAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());

        return "employees";
    }

    @GetMapping("employees/new")
    public String createEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee (@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));

        return "edit_employee";
    }

    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id,
                                @ModelAttribute("employee") Employee employee,
                                Model model) {

        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setEmail(employee.getGender());
        existingEmployee.setEmail(employee.getSalary());

        employeeService.updateEmployee(existingEmployee);

        return "redirect:/employees";

    }

    @GetMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);

        return "redirect:/employees";
    }
}
