package org.trebol.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SellDetailsMapperTest {

    private SellDetailsMapper sellDetailsMapper;

    @BeforeEach
    public void setUp() {
        sellDetailsMapper = new SellDetailsMapperImpl();
    }
}
