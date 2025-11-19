package org.trebol.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class CostumerTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Costumer.class);
        Costumer costumer1 = new Costumer();
        costumer1.setId(1L);
        Costumer costumer2 = new Costumer();
        costumer2.setId(costumer1.getId());
        assertThat(costumer1).isEqualTo(costumer2);
        costumer2.setId(2L);
        assertThat(costumer1).isNotEqualTo(costumer2);
        costumer1.setId(null);
        assertThat(costumer1).isNotEqualTo(costumer2);
    }
}
