package com.prameswaradev.crud_demo_product_supplier.mapper;

import com.prameswaradev.crud_demo_product_supplier.dto.BrandDtoNew;
import com.prameswaradev.crud_demo_product_supplier.dto.BrandSupplierDto;
import com.prameswaradev.crud_demo_product_supplier.entity.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {
    public static BrandDtoNew mapToBrandDto(Brand brand) {
        return new BrandDtoNew(
                brand.getId(),
                brand.getSupplier().getId(),
                brand.getName(),
                brand.getDescription(),
                brand.getImage()
        );
    }

    public static Brand mapToBrand(BrandDtoNew brandDtoNew) {
        return Brand.builder()
                .name(brandDtoNew.getName())
                .description(brandDtoNew.getDescription())
                .build();
    }


}
