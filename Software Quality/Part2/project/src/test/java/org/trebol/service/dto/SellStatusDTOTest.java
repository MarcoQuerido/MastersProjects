package org.trebol.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class SellStatusDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SellStatusDTO.class);
        SellStatusDTO sellStatusDTO1 = new SellStatusDTO();
        sellStatusDTO1.setId(1L);
        SellStatusDTO sellStatusDTO2 = new SellStatusDTO();
        assertThat(sellStatusDTO1).isNotEqualTo(sellStatusDTO2);
        sellStatusDTO2.setId(sellStatusDTO1.getId());
        assertThat(sellStatusDTO1).isEqualTo(sellStatusDTO2);
        sellStatusDTO2.setId(2L);
        assertThat(sellStatusDTO1).isNotEqualTo(sellStatusDTO2);
        sellStatusDTO1.setId(null);
        assertThat(sellStatusDTO1).isNotEqualTo(sellStatusDTO2);
    }
}
