package com.prameswaradev.crud_demo_product_supplier.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandDtoNew {
        private String id;
        private String supplier;
        @Size(min = 4, message = "Minimal 4 character for brand.")
        @NotNull
        private String name;
        @Size(min = 4, message = "Minimal 4 character for description.")
        @NotNull
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
