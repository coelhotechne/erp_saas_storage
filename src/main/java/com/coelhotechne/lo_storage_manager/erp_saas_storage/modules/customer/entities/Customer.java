package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.customer.entities;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.address.AddressBr;
import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.customer.enums.ContactType;
import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.principals.entities.Entidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@Getter
@Setter
@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Customer extends Entidade {
    // nome ou razão social
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type",nullable = false)
    private ContactType contactType;
    @Column(nullable = false)
    private String contact;
    @Embedded
    private AddressBr addressBr;

}
