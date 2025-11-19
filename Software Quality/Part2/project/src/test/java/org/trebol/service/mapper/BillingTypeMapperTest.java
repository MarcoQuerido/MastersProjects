package org.trebol.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BillingTypeMapperTest {

    private BillingTypeMapper billingTypeMapper;

    @BeforeEach
    public void setUp() {
        billingTypeMapper = new BillingTypeMapperImpl();
    }
}
