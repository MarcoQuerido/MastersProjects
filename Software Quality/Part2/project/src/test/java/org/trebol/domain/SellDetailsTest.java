package org.trebol.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class SellDetailsTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SellDetails.class);
        SellDetails sellDetails1 = new SellDetails();
        sellDetails1.setId(1L);
        SellDetails sellDetails2 = new SellDetails();
        sellDetails2.setId(sellDetails1.getId());
        assertThat(sellDetails1).isEqualTo(sellDetails2);
        sellDetails2.setId(2L);
        assertThat(sellDetails1).isNotEqualTo(sellDetails2);
        sellDetails1.setId(null);
        assertThat(sellDetails1).isNotEqualTo(sellDetails2);
    }
}
