package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.api.dto;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.product.ProductSupplier;
import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.domain.Supplier;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JsonPropertyOrder({
        "id",
        "name",
        "cnpj",
        "contact",
        "responsibleName",
        "hiringDate",
        "contractCompletionDate",
        "contractTerminationDate",
        "addressBr",
        "productSuppliers",
        "createdBy",
        "lastModifiedBy",
        "version",
        "createdAt",
        "updatedAt"
})
public record SupplierResponse(

        UUID id,

        String name,

        String cnpj,

        String contact,

        String responsibleName,

        @JsonFormat(
                pattern = "dd/MM/yyyy HH:mm:ss",
                shape = JsonFormat.Shape.STRING
        )
        LocalDateTime hiringDate,

        @JsonFormat(
                pattern = "dd/MM/yyyy HH:mm:ss",
                shape = JsonFormat.Shape.STRING
        )
        LocalDateTime contractCompletionDate,

        @JsonFormat(
                pattern = "dd/MM/yyyy HH:mm:ss",
                shape = JsonFormat.Shape.STRING
        )
        LocalDateTime contractTerminationDate,


        List<ProductSupplier> productSuppliers,
        String createdBy,
        String lastModifiedBy,
        Long version,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static SupplierResponse toResponse(Supplier supplier){
        return new SupplierResponse(
                supplier.getUuid(),
                supplier.getName(),
                supplier.getCnpj(),
                supplier.getContact(),
                supplier.getResponsibleName(),
                supplier.getHiringDate(),
                supplier.getContractCompletionDate(),
                supplier.getContractTerminationDate(),
                supplier.getProductSuppliers(),
                supplier.getCreatedBy(),
                supplier.getLastModifiedBy(),
                supplier.getVersion(),
                supplier.getCreatedAt(),
                supplier.getUpdatedAt()
        );
    }

}