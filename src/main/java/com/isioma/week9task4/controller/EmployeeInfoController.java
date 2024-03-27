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
public class EmployeeInfoController {

        @Autowired
        private EmployeeService employeeService;

        public EmployeeInfoController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

        @PostMapping("/employee_info")
        public String listAllEmployees(Model model) {

            model.addAttribute("employee_info", employeeService.getAllEmployees());

            return "employee_info";
        }

        @GetMapping("add_employee_details/new")
        public String createEmployeeForm(Model model) {
            Employee employee = new Employee();
            model.addAttribute("employee", employee);

            return "add_employee_details";
        }

//        @PostMapping("/add_employee_details")
//        public String saveEmployee (@ModelAttribute("employee") Employee employee) {
//            employeeService.saveEmployee(employee);
//
//            return "add_employee_details";
//        }

        @GetMapping("/edit_employee_info/edit/{id}")
        public String editEmployeeForm(@PathVariable Long id, Model model) {
            model.addAttribute("employee", employeeService.getEmployeeById(id));

            return "edit_employee_info";
        }

        @PostMapping("/employee_info/{id}")
        public String updateEmployee(@PathVariable Long id,
                                     @ModelAttribute("employee") Employee employee,
                                     Model model) {

            Employee existingEmployee = employeeService.getEmployeeById(id);
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setPhoneNumber(employee.getPhoneNumber());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setEmail(employee.getGender());

            employeeService.updateEmployee(existingEmployee);

            return "redirect:/employee_info";

        }

//        @GetMapping("/employees/{id}")
//        public String deleteEmployeeById(@PathVariable Long id) {
//            employeeService.deleteEmployeeById(id);
//
//            return "redirect:/employees";
//        }

}
