package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.api.dto;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.globalClass.mapper.GenericMapper;
import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.domain.Supplier;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SupplierMapper implements GenericMapper<Supplier,SupplierResponse,SupplierRequest> {
    @Override
    public Supplier toEntity(SupplierRequest request) {
        Objects.requireNonNull(request,"Request cannot be null");
        return null;
    }

    @Override
    public SupplierResponse toResponse(Supplier entity) {
        Objects.requireNonNull(entity,"Entity cannot be null");
        return null;
    }
}
