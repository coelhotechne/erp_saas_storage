package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.product.infrastructure;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product>findById(UUID uuid);
}
