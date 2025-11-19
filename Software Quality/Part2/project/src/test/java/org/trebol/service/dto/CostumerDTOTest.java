package org.trebol.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class CostumerDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CostumerDTO.class);
        CostumerDTO costumerDTO1 = new CostumerDTO();
        costumerDTO1.setId(1L);
        CostumerDTO costumerDTO2 = new CostumerDTO();
        assertThat(costumerDTO1).isNotEqualTo(costumerDTO2);
        costumerDTO2.setId(costumerDTO1.getId());
        assertThat(costumerDTO1).isEqualTo(costumerDTO2);
        costumerDTO2.setId(2L);
        assertThat(costumerDTO1).isNotEqualTo(costumerDTO2);
        costumerDTO1.setId(null);
        assertThat(costumerDTO1).isNotEqualTo(costumerDTO2);
    }
}
