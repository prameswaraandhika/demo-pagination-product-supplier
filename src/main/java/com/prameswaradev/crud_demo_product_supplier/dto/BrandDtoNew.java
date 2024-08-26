package com.prameswaradev.crud_demo_product_supplier.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandDtoNew {
        private String id;
        private String supplier;
        private String name;
        private String description;
        private String image;

        @Override
        public String toString() {
                return "Brand{" +
                        "id='" + id + '\'' +
                        ", supplier_id='" + supplier + '\'' +
                        ", name='" + name + '\'' +
                        ", description='" + description + '\'' +
                        ", image='" + image + '\'' +
                        '}';
        }
}
