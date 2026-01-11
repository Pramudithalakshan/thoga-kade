package edu.icet.ecom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private Integer id;
    private String name;
    private Integer nic;
    private String dob;
    private String position;
    private Double salary;
    private String contact;
    private String address;
    private String joinDate;
    private String status;
}
