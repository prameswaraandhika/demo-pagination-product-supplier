package com.prameswaradev.crud_demo_product_supplier.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE supplier SET status_record = 'INACTIVE' WHERE id=?")
@SQLRestriction("status_record = 'ACTIVE'")
@Entity
public class Supplier extends BaseEntity {
    private String name;
    private String email;
    private String numberPhone;

    @OneToMany(mappedBy = "supplier")
    private List<Brand> brands = new ArrayList<>();

    private String image;

}
