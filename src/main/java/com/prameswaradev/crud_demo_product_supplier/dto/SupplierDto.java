package com.prameswaradev.crud_demo_product_supplier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierDto{
    private String name;
    private String email;
    private String numberPhone;

    public SupplierDto(String name, String email, String numberPhone) {
        this.name = name;
        this.email = email;
        this.numberPhone = numberPhone;
    }
}
