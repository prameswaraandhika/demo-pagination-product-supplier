package com.prameswaradev.crud_demo_product_supplier.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BrandSupplierDto {
    private String id;
    private String name;
    private String description;
    private SupplierDto supplier;
    private String image;
}
