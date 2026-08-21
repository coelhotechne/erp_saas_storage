package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

@Getter
public class SupplierNotFoundException extends ErrorResponseException {
    private final String supplierId;
    private final String cnpj;

    public SupplierNotFoundException(String supplierId, String cnpj, String reason){

        super(HttpStatus.NOT_FOUND,buildProblemDetail(supplierId,cnpj,reason),null);
        this.supplierId=supplierId;
        this.cnpj=cnpj;
    }

    private static ProblemDetail buildProblemDetail(String supplierId, String cnpj, String reason){
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,reason);
        pd.setTitle("Not found");
        pd.setProperty("supplierId",supplierId);
        pd.setProperty("cnpj",cnpj);
        return pd;
    }
}
