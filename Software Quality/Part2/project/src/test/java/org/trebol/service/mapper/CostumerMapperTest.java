package org.trebol.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CostumerMapperTest {

    private CostumerMapper costumerMapper;

    @BeforeEach
    public void setUp() {
        costumerMapper = new CostumerMapperImpl();
    }
}
