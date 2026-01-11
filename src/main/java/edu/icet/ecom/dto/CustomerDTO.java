package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    private String id;
    private String title;
    private String name;
    private String dob;
    private String address;
    private String city;
    private String province;
    private Integer postalCode;
}
