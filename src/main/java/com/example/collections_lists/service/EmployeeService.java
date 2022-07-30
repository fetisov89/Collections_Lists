package com.example.collections_lists.service;
import com.example.collections_lists.Employee;
import com.example.collections_lists.Exceptions.EmployeeAlreadyAddedException;
import com.example.collections_lists.Exceptions.EmployeeNotFoundException;
import com.example.collections_lists.Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    ArrayList<Employee> employeeList;
    private final int maxEmployee;

    public EmployeeService() {
        this.employeeList = new ArrayList<>();
        this.maxEmployee = 3;
    }

    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employeeList.size() < maxEmployee) {
            employeeList.add(employee);
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }

    public void deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).equals(employee)) {
                employeeList.remove(employee);
            }
        }
    }

    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public ArrayList<Employee> printAllEmployees() {
        return employeeList;
    }
}