package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.api.dto;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.domain.Supplier;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SupplierRequest(

        @NotBlank
        String name,

        @NotBlank
        String cnpj,

        @NotBlank
        String contact,

        String responsibleName,

        @NotNull
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
        String addressId
) {
    public static Supplier toEntity(SupplierRequest supplierRequest){
        return new Supplier(
                supplierRequest.name(),
                supplierRequest.cnpj(),
                supplierRequest.contact(),
                supplierRequest.responsibleName(),
                supplierRequest.hiringDate(),
                supplierRequest.contractCompletionDate(),
                supplierRequest.contractTerminationDate()
        );
    }
}