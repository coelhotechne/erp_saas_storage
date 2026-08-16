package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.supplier.domain;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.address.entities.AddressBr;
import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.customer.enums.ContactType;
import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.baseClass.entities.BaseEntity;
import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.product.ProductSupplier;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "individual_supplier")
@Getter
@Setter
@Table(name = "individual_supplier")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IndividualSupplier extends BaseEntity {
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "contact_type",nullable = false)
    private ContactType contactType;
    @Column(unique = true)
    private String contact;
    @CPF
    @Column(length = 11,unique = true)
    private String cpf;

    @OneToMany(mappedBy = "supplier",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductSupplier> productSuppliers = new ArrayList<>();

    //Se houver contrato de fornecimento: senão manter em branco

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
    private AddressBr addressBr;


}
