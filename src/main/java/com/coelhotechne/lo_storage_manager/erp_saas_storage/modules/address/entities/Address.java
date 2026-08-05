package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.address.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
