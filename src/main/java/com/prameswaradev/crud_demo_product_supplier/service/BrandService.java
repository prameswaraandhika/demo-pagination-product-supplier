package com.prameswaradev.crud_demo_product_supplier.service;


import com.prameswaradev.crud_demo_product_supplier.dto.BrandDtoNew;
import com.prameswaradev.crud_demo_product_supplier.dto.BrandSupplierDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandService {
    Page<BrandSupplierDto> findAllBrands(Pageable paging);
    void createBrand(BrandDtoNew brandDtoNew);
    BrandDtoNew getBrandById(String brandId);
    void deleteBrandById(String brandId);

    Page<BrandSupplierDto> findAllByName(String keyword, Pageable paging);

//    Page<BrandDtoNew> findAllByName(String name, Pageable pageable);
}
