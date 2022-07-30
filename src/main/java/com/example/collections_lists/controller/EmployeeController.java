package com.example.collections_lists.controller;
import com.example.collections_lists.Employee;
import com.example.collections_lists.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam(name = "firstName", required = false) String firstName,
                              @RequestParam(name = "lastName", required = false) String lastName) {
        employeeService.addEmployee(firstName, lastName);
        return "Added";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam(name = "firstName", required = false) String firstName,
                                 @RequestParam(name = "lastName", required = false) String lastName) {
        employeeService.deleteEmployee(firstName, lastName);
        return "Removed";
    }

    @GetMapping("/search")
    public Employee deleteEmployee(@RequestParam(name = "firstName", required = false) String firstName,
                                   @RequestParam(name = "lastName", required = false) String lastName) {
        return employeeService.searchEmployee(firstName, lastName);
    }

    @GetMapping("/allEmployees")
    public ArrayList<Employee> printAllEmployees() {
        return employeeService.printAllEmployees();
    }
}
