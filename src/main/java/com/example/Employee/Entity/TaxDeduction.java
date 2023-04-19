package com.example.Employee.Entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
@Data
@Qualifier

public class TaxDeduction {

    public String employeeId;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumbers;
    public String dateOfJoining;
    public double salaryPerMonth;

    public TaxDeduction(String employeeId, String firstName, String lastName, String email, String phoneNumbers, String dateOfJoining, double salaryPerMonth) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.dateOfJoining = dateOfJoining;
        this.salaryPerMonth = salaryPerMonth;
    }

    public TaxDeduction() {

    }

    @Override
    public String toString() {
        return "TaxDeduction{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", salaryPerMonth=" + salaryPerMonth +
                '}';
    }
}
