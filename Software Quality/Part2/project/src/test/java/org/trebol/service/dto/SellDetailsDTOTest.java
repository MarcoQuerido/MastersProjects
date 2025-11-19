package org.trebol.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class SellDetailsDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SellDetailsDTO.class);
        SellDetailsDTO sellDetailsDTO1 = new SellDetailsDTO();
        sellDetailsDTO1.setId(1L);
        SellDetailsDTO sellDetailsDTO2 = new SellDetailsDTO();
        assertThat(sellDetailsDTO1).isNotEqualTo(sellDetailsDTO2);
        sellDetailsDTO2.setId(sellDetailsDTO1.getId());
        assertThat(sellDetailsDTO1).isEqualTo(sellDetailsDTO2);
        sellDetailsDTO2.setId(2L);
        assertThat(sellDetailsDTO1).isNotEqualTo(sellDetailsDTO2);
        sellDetailsDTO1.setId(null);
        assertThat(sellDetailsDTO1).isNotEqualTo(sellDetailsDTO2);
    }
}
