package com.prameswaradev.crud_demo_product_supplier.service.impl;

import com.prameswaradev.crud_demo_product_supplier.dto.BrandDtoNew;
import com.prameswaradev.crud_demo_product_supplier.dto.BrandSupplierDto;
import com.prameswaradev.crud_demo_product_supplier.exception.NotFoundException;
import com.prameswaradev.crud_demo_product_supplier.mapper.BrandMapper;
import com.prameswaradev.crud_demo_product_supplier.repository.BrandRepository;
import com.prameswaradev.crud_demo_product_supplier.repository.SupplierRepository;
import com.prameswaradev.crud_demo_product_supplier.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final SupplierRepository supplierRepository;

    @Override
    public Page<BrandSupplierDto> findAllBrands(Pageable pageable) {
        return brandRepository.findAllBrandsWithSupplier(pageable);
    }

    @Override
    public void createBrand(BrandDtoNew brandDtoNew) {
        var supplierId = brandDtoNew.getSupplierId();
        var supplier = supplierRepository.findById(supplierId).orElseThrow(
                () -> new NotFoundException(String.format("supplier with id %s not existed", supplierId))
        );
        var brand = BrandMapper.mapToBrand(brandDtoNew);
        brand.setSupplier(supplier);
        brandRepository.save(brand);
    }

    @Override
    public BrandDtoNew getBrandById(String brandId) {
        return null;
    }

    @Override
    public void deleteBrandById(String brandId) {

    }

    @Override
    public Page<BrandSupplierDto> findAllByName(String name, Pageable pageable) {
        return brandRepository.findByName(name, pageable);
    }
}
