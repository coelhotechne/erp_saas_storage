package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.product;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.baseClass.entities.BaseEntity;
import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.domain.Supplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@Entity(name = "product_supplier")
@Getter
@Setter
@Table(name = "product_supplier")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductSupplier extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "supplierId")
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "productId")
    @JoinColumn(name = "product_id")
    private Product product;

    private BigDecimal negotiatedPrice;
    private Integer leadTimeDays;
    private String supplierProductCode;
}
