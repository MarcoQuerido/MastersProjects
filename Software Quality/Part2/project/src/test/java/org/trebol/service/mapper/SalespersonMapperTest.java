package org.trebol.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalespersonMapperTest {

    private SalespersonMapper salespersonMapper;

    @BeforeEach
    public void setUp() {
        salespersonMapper = new SalespersonMapperImpl();
    }
}
