package com.example.Employee.Entity;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
@Data
@Entity
public class Employee {
    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumbers;
    private String dateOfJoining;
    private double salaryPerMonth;


}

