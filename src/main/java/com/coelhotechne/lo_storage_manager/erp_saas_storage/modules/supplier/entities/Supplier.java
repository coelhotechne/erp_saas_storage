package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.entities;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.address.entities.AddressBr;
import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.principals.entities.Entidade;
import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.product.ProductSupplier;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "supplier")
@Getter
@Setter
@Table(name = "supplier")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Supplier extends Entidade {

    //nome da empresa:
    @Column(nullable = false)
    private String name;
    @CNPJ
    @Column(length = 14,unique = true)
    private String cnpj;
    //Nome da pessoa
    @Column
    private String responsibleName;
    @OneToMany(mappedBy = "supplier",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductSupplier>productSuppliers = new ArrayList<>();

    //Data de contratação
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime hiringDate;

    //Data de finalização do contrato
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime contractCompletionDate;

    // Data de rompimento de contrato caso haja
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime contractTerminationDate;
    @Column(name = "address_br",nullable = false)
    @Embedded
    private AddressBr addressBr;

}
