package com.prameswaradev.crud_demo_product_supplier.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BrandDtoNew {
        private String id;
        private String supplierId;
        private String name;
        private String description;
        private String image;
}
