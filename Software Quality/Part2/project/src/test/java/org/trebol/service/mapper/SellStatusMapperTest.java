package org.trebol.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SellStatusMapperTest {

    private SellStatusMapper sellStatusMapper;

    @BeforeEach
    public void setUp() {
        sellStatusMapper = new SellStatusMapperImpl();
    }
}
