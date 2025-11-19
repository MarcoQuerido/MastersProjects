package org.trebol.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class SellDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SellDTO.class);
        SellDTO sellDTO1 = new SellDTO();
        sellDTO1.setId(1L);
        SellDTO sellDTO2 = new SellDTO();
        assertThat(sellDTO1).isNotEqualTo(sellDTO2);
        sellDTO2.setId(sellDTO1.getId());
        assertThat(sellDTO1).isEqualTo(sellDTO2);
        sellDTO2.setId(2L);
        assertThat(sellDTO1).isNotEqualTo(sellDTO2);
        sellDTO1.setId(null);
        assertThat(sellDTO1).isNotEqualTo(sellDTO2);
    }
}
