package com.prameswaradev.crud_demo_product_supplier.repository;

import com.prameswaradev.crud_demo_product_supplier.dto.BrandSupplierDto;
import com.prameswaradev.crud_demo_product_supplier.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
    @Query("SELECT new com.prameswaradev.crud_demo_product_supplier.dto.BrandSupplierDto(" +
            "b.id, b.name, b.description, " +
            "new com.prameswaradev.crud_demo_product_supplier.dto.SupplierDto(" +
            "s.name, s.email, s.numberPhone), " +
            "b.image) " +
            "FROM Brand b " +
            "JOIN b.supplier s")
    Page<BrandSupplierDto> findAllBrandsWithSupplier(Pageable pageable);


    @Query("SELECT new com.prameswaradev.crud_demo_product_supplier.dto.BrandSupplierDto(" +
            "b.id, b.name, b.description, " +
            "new com.prameswaradev.crud_demo_product_supplier.dto.SupplierDto(" +
            "s.name, s.email, s.numberPhone), " +
            "b.image) " +
            "FROM Brand b " +
            "JOIN b.supplier s " +
            "WHERE b.name LIKE %:name%")
    Page<BrandSupplierDto> findByName(@Param("name") String name, Pageable pageable);
}
