package edu.icet.ecom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private String itemCode;
    private String description;
    private String category;
    private Integer qty;
    private Double unitPrice;
}
