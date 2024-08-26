package com.prameswaradev.crud_demo_product_supplier.config;

import com.prameswaradev.crud_demo_product_supplier.entity.Brand;
import com.prameswaradev.crud_demo_product_supplier.entity.Supplier;
import com.prameswaradev.crud_demo_product_supplier.repository.BrandRepository;
import com.prameswaradev.crud_demo_product_supplier.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private BrandRepository brandRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public DataInitializer(BrandRepository brandRepository, SupplierRepository supplierRepository) {
        this.brandRepository = brandRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save suppliers
        List<Supplier> suppliers = Arrays.asList(
                Supplier.builder()
                        .email("contact@nestle.com")
                        .name("Nestlé S.A.")
                        .numberPhone("+41-21-924-1111")
                        .build(),
                Supplier.builder()
                        .email("contact@pepsico.com")
                        .name("PepsiCo, Inc.")
                        .numberPhone("+1-914-253-2000")
                        .build(),
                Supplier.builder()
                        .email("contact@kraftheinz.com")
                        .name("The Kraft Heinz Company")
                        .numberPhone("+1-847-646-2000")
                        .build(),
                Supplier.builder()
                        .email("contact@unilever.com")
                        .name("Unilever")
                        .numberPhone("+44-20-7822-5252")
                        .build(),
                Supplier.builder()
                        .email("contact@danone.com")
                        .name("Danone S.A.")
                        .numberPhone("+33-1-44-35-20-20")
                        .build()
        );

        supplierRepository.saveAll(suppliers);

        // Create and save brands
        List<Brand> brands = Arrays.asList(
                // Brands for Nestlé S.A.
                Brand.builder()
                        .description("Global leader in dairy products, baby nutrition, and bottled water.")
                        .name("Danone")
                        .supplier(suppliers.get(4)) // Associated with Danone S.A.
                        .image("danone_logo.png")
                        .build(),
                Brand.builder()
                        .description("Leading brand in snacks, beverages, and convenience foods.")
                        .name("PepsiCo")
                        .supplier(suppliers.get(1)) // Associated with PepsiCo, Inc.
                        .image("pepsico_logo.png")
                        .build(),
                Brand.builder()
                        .description("Known for a wide range of food products, including beverages and confectionery.")
                        .name("Nestlé")
                        .supplier(suppliers.get(0)) // Associated with Nestlé S.A.
                        .image("nestle_logo.png")
                        .build(),
                Brand.builder()
                        .description("Famous for sauces, snacks, and ready meals.")
                        .name("Kraft Heinz")
                        .supplier(suppliers.get(2)) // Associated with The Kraft Heinz Company
                        .image("kraftheinz_logo.png")
                        .build(),
                Brand.builder()
                        .description("Global brand offering a wide range of food and personal care products.")
                        .name("Unilever")
                        .supplier(suppliers.get(3)) // Associated with Unilever
                        .image("unilever_logo.png")
                        .build(),

                // Additional brands for each supplier
                // Brands for Nestlé S.A.
                Brand.builder()
                        .description("A popular choice for premium chocolate bars and confectioneries.")
                        .name("KitKat")
                        .supplier(suppliers.get(0)) // Associated with Nestlé S.A.
                        .image("kitkat_logo.png")
                        .build(),
                Brand.builder()
                        .description("Renowned for high-quality coffee products.")
                        .name("Nespresso")
                        .supplier(suppliers.get(0)) // Associated with Nestlé S.A.
                        .image("nespresso_logo.png")
                        .build(),

                // Brands for PepsiCo, Inc.
                Brand.builder()
                        .description("Famous for a wide range of carbonated beverages.")
                        .name("Pepsi")
                        .supplier(suppliers.get(1)) // Associated with PepsiCo, Inc.
                        .image("pepsi_logo.png")
                        .build(),
                Brand.builder()
                        .description("Known for a variety of snack foods including chips and pretzels.")
                        .name("Lay's")
                        .supplier(suppliers.get(1)) // Associated with PepsiCo, Inc.
                        .image("lays_logo.png")
                        .build(),

                // Brands for The Kraft Heinz Company
                Brand.builder()
                        .description("Popular for ketchup and other sauces.")
                        .name("Heinz")
                        .supplier(suppliers.get(2)) // Associated with The Kraft Heinz Company
                        .image("heinz_logo.png")
                        .build(),
                Brand.builder()
                        .description("Known for a variety of packaged meals and snacks.")
                        .name("Kraft")
                        .supplier(suppliers.get(2)) // Associated with The Kraft Heinz Company
                        .image("kraft_logo.png")
                        .build(),

                // Brands for Unilever
                Brand.builder()
                        .description("Offers a range of ice cream products including popular flavors.")
                        .name("Ben & Jerry's")
                        .supplier(suppliers.get(3)) // Associated with Unilever
                        .image("benandjerrys_logo.png")
                        .build(),
                Brand.builder()
                        .description("Famous for its range of personal care products.")
                        .name("Dove")
                        .supplier(suppliers.get(3)) // Associated with Unilever
                        .image("dove_logo.png")
                        .build(),

                // Brands for Danone S.A.
                Brand.builder()
                        .description("Well-known for its yogurt and dairy-based products.")
                        .name("Activia")
                        .supplier(suppliers.get(4)) // Associated with Danone S.A.
                        .image("activia_logo.png")
                        .build(),
                Brand.builder()
                        .description("Provider of plant-based and dairy-free yogurt options.")
                        .name("Alpro")
                        .supplier(suppliers.get(4)) // Associated with Danone S.A.
                        .image("alpro_logo.png")
                        .build()
        );

        brandRepository.saveAll(brands);
    }


}