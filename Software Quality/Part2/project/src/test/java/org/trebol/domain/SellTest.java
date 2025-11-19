package org.trebol.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class SellTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Sell.class);
        Sell sell1 = new Sell();
        sell1.setId(1L);
        Sell sell2 = new Sell();
        sell2.setId(sell1.getId());
        assertThat(sell1).isEqualTo(sell2);
        sell2.setId(2L);
        assertThat(sell1).isNotEqualTo(sell2);
        sell1.setId(null);
        assertThat(sell1).isNotEqualTo(sell2);
    }
}
