package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.product;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSupplierId implements Serializable {
    private UUID supplierId;
    private UUID productId;
}
