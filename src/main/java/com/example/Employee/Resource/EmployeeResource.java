package com.example.Employee.Resource;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Entity.TaxDeduction;
import com.example.Employee.Service.EmployeeService;
//import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Valid
@RequestMapping("/employees")
public class EmployeeResource {
    @Autowired
    EmployeeService employeeService;

    private Map<String, Employee> employees = new HashMap<>();

    @PostMapping("/employees")
    public Employee addEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.addEmployee(employee);

    }

    @GetMapping("/employees/tax-deduction")
    public ResponseEntity<List<TaxDeduction>> getTaxDeductionForCurrentYear() {
        List<TaxDeduction> taxDeductions = new ArrayList<>();
        for (Employee employee : employees.values()) {
            TaxDeduction taxDeduction = new TaxDeduction();
            taxDeduction.setEmployeeId(employee.getEmployeeId());
            taxDeduction.setFirstName(employee.getFirstName());
            taxDeduction.setLastName(employee.getLastName());

            double yearlySalary = employee.getSalaryPerMonth() * 12;
            double taxAmount = 0;


            if (yearlySalary > 250000 && yearlySalary <= 500000) {
                taxAmount = (yearlySalary - 250000) * 0.05;
            } else if (yearlySalary > 500000 && yearlySalary <= 1000000) {
                taxAmount = (yearlySalary - 500000) * 0.1 + 25000;
            } else if (yearlySalary > 1000000) {
                taxAmount = (yearlySalary - 1000000) * 0.2 + 75000;
            }




            taxDeductions.add(taxDeduction);
        }

        return new ResponseEntity<>(taxDeductions, HttpStatus.OK);
    }

}
