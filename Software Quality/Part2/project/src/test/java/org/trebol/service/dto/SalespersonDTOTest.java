package org.trebol.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class SalespersonDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SalespersonDTO.class);
        SalespersonDTO salespersonDTO1 = new SalespersonDTO();
        salespersonDTO1.setId(1L);
        SalespersonDTO salespersonDTO2 = new SalespersonDTO();
        assertThat(salespersonDTO1).isNotEqualTo(salespersonDTO2);
        salespersonDTO2.setId(salespersonDTO1.getId());
        assertThat(salespersonDTO1).isEqualTo(salespersonDTO2);
        salespersonDTO2.setId(2L);
        assertThat(salespersonDTO1).isNotEqualTo(salespersonDTO2);
        salespersonDTO1.setId(null);
        assertThat(salespersonDTO1).isNotEqualTo(salespersonDTO2);
    }
}
