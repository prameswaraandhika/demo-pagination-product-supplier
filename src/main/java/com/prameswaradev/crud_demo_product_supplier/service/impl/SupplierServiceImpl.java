package com.prameswaradev.crud_demo_product_supplier.service.impl;

import com.prameswaradev.crud_demo_product_supplier.entity.Supplier;
import com.prameswaradev.crud_demo_product_supplier.repository.SupplierRepository;
import com.prameswaradev.crud_demo_product_supplier.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }
}
