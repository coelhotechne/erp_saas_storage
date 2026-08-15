package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.address.entities;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.address.enums.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tb_address")
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Country country;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String city;

    private String district;

    @Column(nullable = false)
    private String street;

    private String number;

    private String complement;

}