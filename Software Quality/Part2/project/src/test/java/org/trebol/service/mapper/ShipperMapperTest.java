package org.trebol.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipperMapperTest {

    private ShipperMapper shipperMapper;

    @BeforeEach
    public void setUp() {
        shipperMapper = new ShipperMapperImpl();
    }
}
