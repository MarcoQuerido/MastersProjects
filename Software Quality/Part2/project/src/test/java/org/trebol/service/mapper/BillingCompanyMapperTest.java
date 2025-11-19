package org.trebol.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BillingCompanyMapperTest {

    private BillingCompanyMapper billingCompanyMapper;

    @BeforeEach
    public void setUp() {
        billingCompanyMapper = new BillingCompanyMapperImpl();
    }
}
