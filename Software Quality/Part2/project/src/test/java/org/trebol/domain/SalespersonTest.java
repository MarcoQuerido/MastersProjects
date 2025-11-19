package org.trebol.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class SalespersonTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Salesperson.class);
        Salesperson salesperson1 = new Salesperson();
        salesperson1.setId(1L);
        Salesperson salesperson2 = new Salesperson();
        salesperson2.setId(salesperson1.getId());
        assertThat(salesperson1).isEqualTo(salesperson2);
        salesperson2.setId(2L);
        assertThat(salesperson1).isNotEqualTo(salesperson2);
        salesperson1.setId(null);
        assertThat(salesperson1).isNotEqualTo(salesperson2);
    }
}
