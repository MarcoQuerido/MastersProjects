package org.trebol.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class ShipperTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Shipper.class);
        Shipper shipper1 = new Shipper();
        shipper1.setId(1L);
        Shipper shipper2 = new Shipper();
        shipper2.setId(shipper1.getId());
        assertThat(shipper1).isEqualTo(shipper2);
        shipper2.setId(2L);
        assertThat(shipper1).isNotEqualTo(shipper2);
        shipper1.setId(null);
        assertThat(shipper1).isNotEqualTo(shipper2);
    }
}
