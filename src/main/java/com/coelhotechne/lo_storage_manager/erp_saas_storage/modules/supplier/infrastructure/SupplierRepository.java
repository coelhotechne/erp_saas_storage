package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.infrastructure;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
    @Override
    Optional<Supplier> findById(UUID uuid);
}
