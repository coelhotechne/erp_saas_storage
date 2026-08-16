package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.address.entities;

import com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.address.enums.StateBr;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;


//Classe em portugues
@Embeddable
public class AddressBr {
    @Column(nullable = false, length = 100)
    private String logradouro;
    @Column(nullable = false, length = 10)
    private String numero;
    @Column(nullable = false, length = 100 )
    private String complemento;
    @Column(nullable = false, length = 100 )
    private String bairro;
    @Column(nullable = false, length = 100)
    private String cidade;
    @Column(nullable = false, length = 20)
    private StateBr estado;
    @Column(nullable = false, length = 10)
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O campo 'cep' deve ter o formato '12345-678'")
    private String cep;
}
