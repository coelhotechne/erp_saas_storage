package com.coelhotechne.lo_storage_manager.erp_saas_storage.modules.address.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Country {
    BRAZIL(
            "BR",
            "Brasil",
            "BRA",
            "+55",
            "pt-BR",
            "BRL",
            "America/Sao_Paulo"
    ),

    USA(
            "US",
            "United States",
            "USA",
            "+1",
            "en-US",
            "USD",
            "America/New_York"
    );

    /**
     * ISO 3166-1 Alpha-2
     */
    private final String iso2;

    /**
     * Nome oficial
     */
    private final String name;

    /**
     * ISO 3166-1 Alpha-3
     */
    private final String iso3;

    /**
     * Código telefônico
     */
    private final String phoneCode;

    /**
     * Idioma padrão
     */
    private final String locale;

    /**
     * Moeda
     */
    private final String currency;

    /**
     * Timezone principal
     */
    private final String timezone;
}
