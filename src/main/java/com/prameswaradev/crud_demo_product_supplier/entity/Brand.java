package com.prameswaradev.crud_demo_product_supplier.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE brand SET status_record = 'INACTIVE' WHERE id=?")
@SQLRestriction("status_record = 'ACTIVE'")
@Entity
public class Brand extends BaseEntity{

    @NotNull
    private String name;

    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private String image;

}
