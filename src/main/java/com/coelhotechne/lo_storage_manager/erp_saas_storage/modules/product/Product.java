package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.product;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.principals.entities.Entidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Product extends Entidade {
    @Column(name = "name",nullable = false,length = 50)
    private String name;
    @Column(name = "sku",nullable = false,unique = true)
    private String sku;
    @Column(name = "description",nullable = false)
    private String description;
    //define os fornecedores do produto
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductSupplier>productSuppliers=new ArrayList<>();
    @Column(name = "maintenance_cost",nullable = false,scale = 2, precision = 20)
    private BigDecimal maintenanceCost;
    @Column(name = "total_cost",nullable = false,scale = 2, precision = 20)
    private BigDecimal totalCost;
    @Column(name = "product_cost",nullable = false,scale = 2, precision = 20)
    private BigDecimal productCost;
    @Column(name = "taxes",nullable = false,scale = 2, precision = 20)
    private BigDecimal taxes;
}
